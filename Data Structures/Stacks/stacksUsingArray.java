import java.util.*;

public class stacksUsingArray {
    static int top = -1;
    static int max = 10;

    // Stack class
    static class Stack {
        int arr[];
    }

    // pop method
    public static int pop(Stack st) {
        if (isEmpty(st)) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int val = st.arr[top];
            top--;
            return val;
        }
    }

    // push method
    public static void push(Stack st, int val) {
        if (isFull(st)) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            st.arr[top] = val;
        }
    }

    // peek method
    public static int peek(Stack st) {
        if (isEmpty(st)) {
            System.out.println("Stack is empty");
            return -1;
        }
        return st.arr[top];
    }

    // isEmpty method
    public static boolean isEmpty(Stack st) {
        return top == -1;
    }

    // isFull method
    public static boolean isFull(Stack st) {
        return top == max - 1;
    }

    // main method should be inside the same class
    public static void main(String[] args) {
        Stack st = new Stack();
        st.arr = new int[max];

        push(st, 10);
        push(st, 20);
        push(st, 30);

        System.out.println("Top element is: " + peek(st));

        System.out.println("Elements:");
        while (!isEmpty(st)) {
            System.out.println(pop(st));
        }

        System.out.println("Stack empty: " + isEmpty(st));
    }
}
