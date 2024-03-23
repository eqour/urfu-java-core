package ru.eqour.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Task143 {

    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
        ListNode node = null;
        for (int s = 0, e = nodes.size() - 1; s <= e; s++, e--) {
            if (s == e) {
                if (node == null) {
                    node = nodes.get(s);
                } else {
                    node.next = nodes.get(s);
                    node = node.next;
                }
            } else {
                if (node == null) {
                    node = nodes.get(s);
                } else {
                    node.next = nodes.get(s);
                    node = node.next;
                }
                node.next = nodes.get(e);
                node = node.next;
            }
        }
        if (node != null) {
            node.next = null;
        }
    }

     // Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
