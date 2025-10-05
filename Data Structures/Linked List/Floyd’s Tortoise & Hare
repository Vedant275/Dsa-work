import java.util.*;

/**
 *  Q. Detect cycle in a linked list (Floyd’s Tortoise & Hare).
 *  In this method two pointers are used one points to the
 *  next node (Tortoise) and the other points to the next
 *  to next pointer (Hare)
 */

public class Main {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    public Main() {
        this.head = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Detect cycle using Floyd’s Tortoise & Hare
    public boolean detectCycle(Node head){
        Node current = head;
        if(head == null || head.next ==null){
            return false;
        }
        /* Declaring 2 pointers because one points to the next node and
        other points to the next to the next node
         */
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Main myList = new Main();
        myList.addNode(10);
        myList.addNode(30);
        myList.addNode(50);
        myList.addNode(30);
        myList.head.next.next.next = myList.head.next;
        boolean checkcycle = myList.detectCycle(myList.head);
        if(checkcycle){
            System.out.println("The linked list is a circular ");
        }
        else{
            System.out.println("The linked list is not circular");
        }
    }
}
