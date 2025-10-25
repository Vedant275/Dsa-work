import java.util.*;

/**
 * Q. Find if the Linked list is
 * a palindrome or not
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
    Node head = null;
    public Main() {
        this.head = null;
    }
    public boolean checkPalindrome() {
        /* check if the linked list is empty
           or having a single element */
        if (head == null || head.next == null) 
        return true;

        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /* reversing the nodes after the
           middle of the linked list  */
        Node current = slow;
        Node prev = null;
        while(current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        // checking the nodes for palindrome
        Node temp1 = head, temp2 = prev;
        while(temp2 != null) {
            if(temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else {
                return false;
            }
        }
        return true;
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
    public static void main(String[] args) {
        Main myList = new Main();
        myList.addNode(10);
        myList.addNode(20);
        myList.addNode(30);
        myList.addNode(20);
        myList.addNode(10);
        System.out.println(myList.checkPalindrome());
    }
}
