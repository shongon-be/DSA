package datastructure.linkedlist.singly;

public class Node {
    int value;
    Node next; // the 'next' variable can reference to another node

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
