import java.util.*;

/**
 * Q. Find the middle of a linked list
 * A variable count is initialised which counts the number
 * of nodes and then return the index number which comes
 * in the middle
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
    /* For even-sized list,
       picks the first (left) middle
    */
    public int getMiddleNodeIndex() {
        Node current = head;
        int count = 0;
        if (head == null) {
            return -1;     // if node is empty
        }
        while (current != null) {
            current = current.next;
            count++;
        }
        return ((count + 1) / 2);
    }
    public void addLast(int data) {
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
        myList.addLast(10);
        myList.addLast(20);
        myList.addLast(30);
        myList.addLast(40);
        System.out.println(myList.getMiddleNodeIndex());
    }
}
