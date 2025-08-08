package DataStructure.LinkedList;

import DataStructure.LinkedList.Singly.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList();

//        myLinkedList.getHead();
//        myLinkedList.getTail();
//        myLinkedList.getLength();

        myLinkedList.append(10);
        myLinkedList.append(15);

        myLinkedList.printList();

        myLinkedList.removeLast();
        myLinkedList.removeLast();

        myLinkedList.printList();

    }
}
