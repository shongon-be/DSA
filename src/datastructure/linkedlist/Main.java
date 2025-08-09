package datastructure.linkedlist;

import datastructure.linkedlist.singly.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList mySinglyLinkedList = new SinglyLinkedList();

//        myLinkedList.getHead();
//        myLinkedList.getTail();
//        myLinkedList.getLength();

        mySinglyLinkedList.append(10);

        mySinglyLinkedList.printList();

//        myLinkedList.removeLast();

//        myLinkedList.printList();
//        myLinkedList.getLength();

        mySinglyLinkedList.prepend(100);
        mySinglyLinkedList.prepend(2);
        mySinglyLinkedList.printList();

        mySinglyLinkedList.removeFirst();
        mySinglyLinkedList.printList();

        System.out.println(mySinglyLinkedList.get(0).getValue());

        mySinglyLinkedList.set(0, 2);
        mySinglyLinkedList.printList();

        mySinglyLinkedList.insert(1, 1);
        mySinglyLinkedList.printList();

//        System.out.println(myLinkedList.remove(1).getValue());
//        myLinkedList.printList();

        mySinglyLinkedList.reverse();
        mySinglyLinkedList.printList();

    }
}
