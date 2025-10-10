/**
 * Q. Implement a Stack using Linked List
 * Approach:
 * 1. Use a Node class to represent each element with `data` and `next`.
 * 2. Maintain a `head` pointer representing the top of the stack.
 * 3. `push()` adds a new node at the top.
 * 4. `pop()` removes the top node.
 * 5. `top()` returns the value of the top node without removing it.
 */

public class stackClass {

    // Node class for linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class stack {
        public static Node head; // top of the stack

        // Push element onto stack
        public static void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // Pop element from stack
        public static void pop() {
            if (head == null) {
                return;
            }
            head = head.next;
        }

        // Peek at top element
        public static int top() {
            if (head == null) {
                return 0; // or could return -1 to indicate empty
            }
            return head.data;
        }
    }

    public static void main(String args[]) {
        stack s = new stack();
        s.push(41);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // Print and remove all elements
        while (stack.head != null) {
            System.out.println(s.top());
            s.pop();
        }
    }
}
