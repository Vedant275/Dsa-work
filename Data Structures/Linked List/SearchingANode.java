/**
 *  Q. Search for a given value in a singly linked list
 *  Approach:
 *  Traverse the linked list node by node starting from the head.
 *  Compare each node’s data with the target value.
 *  If a match is found, return the reference to that node.
 *  If the end of the list is reached and no match is found, return null.
 */

public class MyLinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    public MyLinkedList() {
        this.head = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Node searchForNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null ;
    }
    
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addNode(10);
        myList.addNode(20);
        myList.addNode(30);
        myList.addNode(40);
        System.out.println(myList.searchForNode(20));
    }
}
