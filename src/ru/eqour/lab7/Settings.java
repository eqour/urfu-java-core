package ru.eqour.lab7;

import java.io.Serializable;
import java.util.List;

public class Settings implements Serializable {

    private String path;
    private int version;
    private List<Integer> storedNumbers;

    public Settings(String path, int version, List<Integer> storedNumbers) {
        this.path = path;
        this.version = version;
        this.storedNumbers = storedNumbers;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Integer> getStoredNumbers() {
        return storedNumbers;
    }

    public void setStoredNumbers(List<Integer> storedNumbers) {
        this.storedNumbers = storedNumbers;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "path='" + path + '\'' +
                ", version=" + version +
                ", storedNumbers=" + storedNumbers +
                '}';
    }
}
