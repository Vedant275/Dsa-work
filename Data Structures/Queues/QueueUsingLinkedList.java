/**
 * Q. Implement a Queue using Linked List
 * Approach:
 * 1. Use a Node class to represent each element with `data` and `next`.
 * 2. Maintain `head` (front) and `tail` (rear) pointers.
 * 3. `add()` inserts a new node at the end (tail) of the queue.
 * 4. `remove()` deletes the front node and returns its value.
 * 5. `peek()` returns the value at the front without removing it.
 * 6. `isEmpty()` checks if the queue has no elements.
 */

public class myQueue {

    // Node class for linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class queue {
        static Node head = null; // points to front of queue
        static Node tail = null; // points to rear of queue

        // Check if queue is empty
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // Add element to the queue
        public static void add(int data) {
            Node newNode = new Node(data);
            if (tail == null && head == null) { // first element
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // Remove element from the queue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("The queue is empty");
                return -1;
            }
            int front = head.data;
            if (head == tail) { // only one element
                head = tail = null;
            } else {
                head = head.next;
            }
            return front;
        }

        // Peek at the front element
        public static int peek() {
            if (isEmpty()) {
                System.out.println("The queue is empty");
                return -1;
            }
            return head.data;
        }

        public static void main(String args[]) {
            queue q = new queue();
            q.add(10);
            q.add(20);
            q.add(30);

            // Print and remove all elements
            while (!q.isEmpty()) {
                System.out.println(q.peek());
                q.remove();
            }
        }
    }
}
