package ru.eqour.lab8.processor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.eqour.lab8.Book;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XmlBookProcessor implements BookProcessor {

    private final String path;

    public XmlBookProcessor(String path) {
        this.path = path;
    }

    @Override
    public List<Book> read() throws FileNotFoundException {
        List<Book> books = new ArrayList<>();
        if (!Files.exists(Paths.get(path))) {
            throw new FileNotFoundException();
        }
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(path));
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    books.add(
                            new Book(
                                    getElementValue(element, "title"),
                                    getElementValue(element, "author"),
                                    Integer.parseInt(getElementValue(element, "year"))
                            )
                    );
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    private String getElementValue(Element element, String key) {
        return element.getElementsByTagName(key).item(0).getTextContent();
    }

    @Override
    public void write(List<Book> books) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);

            for (Book book : books) {
                Element bookElement = doc.createElement("book");
                rootElement.appendChild(bookElement);

                Element title = doc.createElement("title");
                title.appendChild(doc.createTextNode(book.getTitle()));
                bookElement.appendChild(title);

                Element author = doc.createElement("author");
                author.appendChild(doc.createTextNode(book.getAuthor()));
                bookElement.appendChild(author);

                Element year = doc.createElement("year");
                year.appendChild(doc.createTextNode(String.valueOf(book.getYear())));
                bookElement.appendChild(year);
            }

            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
