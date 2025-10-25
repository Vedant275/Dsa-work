/**
 * Finding length of the linked list
 */

public class LengthOfLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    
    public static int lenght(Node head) {
        int length = 0;
        Node node = head;
        // counting till the last node which points null
        while(node.next != null) {
            length++;
            node = node.next;
        }
        return length;
    }
    // Function to add a new node at the end of the list
    public void push(int data) {
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
    public static void main(String[] args) {
        LengthOfLinkedList list = new LengthOfLinkedList();
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        System.out.println(lenght(list.head));
    }
}