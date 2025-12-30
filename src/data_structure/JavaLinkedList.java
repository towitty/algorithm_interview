package data_structure;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class JavaLinkedList {
    private Node head;

    void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(data);
    }
}
