/**
 * Q. Implement a Circular Queue
 * Approach:
 * 1. Use an array to store queue elements.
 * 2. Maintain `front` and `rear` pointers to track the start and end.
 * 3. For adding elements, check if the queue is full;
 *    then update `rear` in circular manner.
 * 4. For removing elements, check if the queue is empty;
 *    then update `front` in circular manner.
 * 5. `peek` returns the element at the front without removing it.
 * 6. Handle empty queue and single-element queue cases properly.
 */

public class Main {
    static class queue {
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;

        queue(int n) {
            arr = new int[n];
            this.size = n;
        }

        // Check if queue is empty
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // Check if queue is full
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add element to the queue
        public static void add(int data) {
            if (isFull()) {
                System.out.println("The queue is full");
                return;
            }
            if (front == -1) {
                front = 0; // first element being added
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Remove element from the queue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("The queue is empty");
                return -1;
            }
            int result = arr[front];
            if (front == rear) { // only one element in queue
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // Peek at the front element
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Nothing to remove");
                return -1;
            }
            return arr[front];
        }

        public static void main(String args[]) {
            queue q = new queue(5); // create a queue of size 5
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
