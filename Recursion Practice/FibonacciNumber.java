import java.util.*;

/**
 * Q. Find the nth Fibonacci number using recursion.
 * Approach:
 * 1. Use recursion to calculate the value:
 *      - Base cases: return 0 when n=0, return 1 when n=1
 *      - Recursive case: return fibo(n-1) + fibo(n-2)
 */

public class Main {
    public static int calculateFibonacci(int i) {
       // Base case 1
        if (i == 0) {
            return 0;
        // Base case 2
        } if (i == 1) {
            return 1;
        }
        return calculateFibonacci(i - 1) + calculateFibonacci(i - 2);
    }

    public static void main(String[] args) {
        System.out.println("the number till which fibonacci is to be founded");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println("Fibonacci number at location" + i + "is " + calculateFibonacci(i));
    }
}
