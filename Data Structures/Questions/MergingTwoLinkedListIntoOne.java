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
