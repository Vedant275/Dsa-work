/**
 * Q. Delete a node with a given value from a singly linked list.
 *
 * Approach:
 * 1. If the list is empty → return false.
 * 2. If the head node itself contains the target value → move head to next node.
 * 3. Otherwise, traverse the list keeping track of the previous node.
 * 4. When the node with the target value is found → link 
 *    previous node to current.next (skip it).
 * 5. If not found till the end → return false.
 */

class MyLinkedList {
    public static class  Node {
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

    public boolean deleteANode(int value) {
        // empty linked list
        if(head == null) {
            return false;
        }
        // only one element
        if(head.data == value) {
            head = head.next;
            return true;
        }
        Node previous = head;
        Node current  = previous.next;
        while(current != null) {
            if(current.data == value) {
                previous.next = current.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addNode(10);
        myList.addNode(20);
        myList.addNode(30);
        myList.addNode(40);
        if(myList.deleteANode(40) == true) {
            System.out.println("The node is deleted");
        }
        else System.out.println("The node couldn't be founded");
    }
}
