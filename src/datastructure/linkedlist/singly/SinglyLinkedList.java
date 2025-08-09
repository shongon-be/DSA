package datastructure.linkedlist.singly;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public SinglyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) { // if value of current is null, then break the loop
            System.out.print(temp.value + " → ");
            temp = temp.next; // move current to next node
        }
        System.out.println("null");
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    // get the value of the node at the given index (position)
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // set the value of the node at the given index (position)
    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp == null) return false;
        temp.value = value;
        return true;
    }


    // append a new node to the end of the list
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // prepend a new node to the beginning of the list
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // insert a new node at the given index (position)
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        } else {
            Node newNode = new Node(value);
            Node temp = get(index - 1); // reach the node before the 'index' node
            newNode.next = temp.next; // connect the newNode with the node at the index.
            temp.next = newNode; // connect the newNode with the node before the 'index' node
            length++;
            return true;
        }
    }

    // remove the first node of the list
    public Node removeFirst() {
        if ((length == 0)) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next; // update 'head' pointer to the next node
            temp.next = null; // remove the connection of the first node
        }
        length--;
        return temp;
    }

    // remove the node at the given index (position)
    public Node remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) return removeFirst();

        if (index == length - 1) return removeLast();

        Node current = get(index - 1); // reach the node before the removed node (1)
        Node temp = current.next; // tracking the node will be removed
        current.next = temp.next; // create a connection between the node (1) and the node after the node will be removed
        temp.next = null; // remove the connection of the removed node with the node next to it
        length--;
        return temp;
    }

    // remove the last node of the list
    public Node removeLast() {
        if (length == 0) return null;

        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            // traversal through the list to reach the node next to the 'tail' node
            while (current.next != tail) {
                current = current.next;
            }
            tail = current; // update tail to the node next to the 'tail' node
            tail.next = null; // remove the connection of the last node
        }
        length--;
        return temp;
    }

    // reverse the list
    public void reverse() {
        if(length == 0 || length == 1) return;
        // Switch position of head and tail
        Node temp = head;
        head = tail;
        tail = temp;
        // Create two new pointers to track the next node and the previous node
        // temp is pointing to the first node
        Node after = temp.next; // after is pointing to the node after the first node
        Node before = null; // before is on '-1' position

        // reverse the connection of the nodes
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}
