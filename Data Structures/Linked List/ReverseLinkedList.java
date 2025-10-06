/**
 * Q.Reverse a linklist iteratively
 * Approach:
 * - Traverse the list once
 * - Keep three pointers: prev, current, and next
 * - Reverse the links one by one so each node points to its previous node
 * - Finally, make 'head' point to the last processed node (prev)
 */

class MyLinkedList {
    public static class Node {
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

    public void reverseLinkedList() {
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printlist() {
        Node current = head;
        if(head == null) {
            System.out.println("the list is empty");
        }
        while(current != null) {
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addNode(10);
        myList.addNode(20);
        myList.addNode(30);
        myList.addNode(40);
        myList.reverseLinkedList();
        myList.printlist();
    }
}
