package DataStructure.LinkedList.Singly;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        Node current = head;

        while(current != null){ // if value of current is null, then break the loop
            System.out.print(current.value + " → ");
            current = current.next; // move current to next node
        }
        System.out.println("null");
    }

    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

}
