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
/*
-----------------------------------------
 Dry Run: Check if Linked List is Palindrome
-----------------------------------------

Input Linked List:
10 → 20 → 30 → 20 → 10

Step | Operation                     | fast | slow | current | prev | Description
-----|--------------------------------|------|------|----------|------|-------------------------------
1    | Initialization                 | 10   | 10   |  -       |  -   | Start of traversal
2    | Move fast & slow               | 30   | 20   |  -       |  -   | slow = 20, fast = 30
3    | Move fast & slow               | 10   | 30   |  -       |  -   | Midpoint found (slow = 30)
4    | Start reversing from mid       |  -   |  -   | 30       | null | Prepare to reverse second half
5    | Reverse link                   |  -   |  -   | 20       | 30   | 30 → null, prev = 30
6    | Reverse link                   |  -   |  -   | 10       | 20   | 20 → 30, prev = 20
7    | Reverse complete               |  -   |  -   | null     | 10   | 10 → 20 → 30 (reversed half)
8    | Compare halves (10 == 10)      |  -   |  -   |  -       |  -   | Match 
9    | Compare halves (20 == 20)      |  -   |  -   |  -       |  -   | Match 
10   | Compare halves (30 == 30)      |  -   |  -   |  -       |  -   | Match 
11   | Comparison complete            |  -   |  -   |  -       |  -   | Both halves traversed
12   | Result                         |  -   |  -   |  -       |  -   | Linked list is a palindrome 

Output:
true
-----------------------------------------
*/
