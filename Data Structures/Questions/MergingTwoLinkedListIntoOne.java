/**
 * Q. Merge two sorted Linked Lists into a new sorted Linked List
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

    // Function to merge two sorted linked lists
    public static Node mergeSortedLists(Node l1, Node l2) {
        Node dummy = new Node(-1); // dummy head
        Node l3 = dummy;           // pointer for merged list

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next; // move ahead
        }

        // attach the remaining part
        if (l1 != null) l3.next = l1;
        if (l2 != null) l3.next = l2;

        return dummy.next; // head of merged list
    }

    // Helper to print a list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // First sorted linked list: 1 -> 3 -> 5
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        // Second sorted linked list: 2 -> 4 -> 6
        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node merged = mergeSortedLists(l1, l2);

        System.out.print("Merged Sorted List: ");
        printList(merged);
    }
}
/*
Dry Run for Merging Two Sorted Linked Lists
--------------------------------------------

Let:
l1 = 1 -> 3 -> 5 -> null
l2 = 2 -> 4 -> 6 -> null

We create a dummy node:
dummy -> null
l3 = dummy (used to build the merged list)

--------------------------------------------
Iteration 1:
- l1.data = 1, l2.data = 2
- Compare: 1 < 2  
  → l3.next = l1
  → Move l1 = l1.next (now l1 points to 3)
  → Move l3 = l3.next (now l3 points to 1)
Result so far:
dummy -> 1
Merged list: 1 -> null

--------------------------------------------
Iteration 2:
- l1.data = 3, l2.data = 2
- Compare: 3 < 2 
  → l3.next = l2
  → Move l2 = l2.next (now l2 points to 4)
  → Move l3 = l3.next (now l3 points to 2)
Result so far:
dummy -> 1 -> 2
Merged list: 1 -> 2 -> null

--------------------------------------------
Iteration 3:
- l1.data = 3, l2.data = 4
- Compare: 3 < 4 
  → l3.next = l1
  → Move l1 = l1.next (now l1 points to 5)
  → Move l3 = l3.next (now l3 points to 3)
Result so far:
dummy -> 1 -> 2 -> 3
Merged list: 1 -> 2 -> 3 -> null

--------------------------------------------
Iteration 4:
- l1.data = 5, l2.data = 4
- Compare: 5 < 4 
  → l3.next = l2
  → Move l2 = l2.next (now l2 points to 6)
  → Move l3 = l3.next (now l3 points to 4)
Result so far:
dummy -> 1 -> 2 -> 3 -> 4
Merged list: 1 -> 2 -> 3 -> 4 -> null

--------------------------------------------
Iteration 5:
- l1.data = 5, l2.data = 6
- Compare: 5 < 6 
  → l3.next = l1
  → Move l1 = l1.next (now l1 = null)
  → Move l3 = l3.next (now l3 points to 5)
Result so far:
dummy -> 1 -> 2 -> 3 -> 4 -> 5
Merged list: 1 -> 2 -> 3 -> 4 -> 5 -> null

--------------------------------------------
End Condition:
- l1 == null 
- So connect remaining l2:
  → l3.next = l2
Final merged list:
dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

--------------------------------------------
Return:
dummy.next (the merged list starting from 1)
Result:
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
*/
