import java.util.*;

/**
 * Q. Print numbers from 1 to n  and n to 1 (first in right order and then in reverse order)
 *    Recursively prints numbers from start to end in ascending order
 *    then prints them back in descending order
 */


public class Main {
    public static void printNumberBackAndForward(int i, int n) {
        if (i > n) {
            return;
        }
        // print in descending order
        System.out.println(i);
        printNumberBackAndForward(i + 1, n);
        // print in descending order
        System.out.println(i);
    }

    public static void main(String[] args) {
        printNumberBackAndForward(1, 5);
    }
}
