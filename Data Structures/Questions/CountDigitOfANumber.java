/**
 * Q. Count the number of digits in a number
 * Approach:
 * 1. Initialize a counter (index) to 0 and a multiplier v to 1.
 * 2. Divide the number by v and check if the result is non-zero.
 * 3. Multiply v by 10 each time and increment the counter.
 * 4. When n/v becomes 0, the counter holds the number of digits.
 */

import java.util.*;

public class Main {

    // Function to count digits in a number
    public static int countdigit(int n) {
        int index = 0; // counter for digits
        int v = 1;     // multiplier

        while ((n / v) != 0) { // loop until n/v becomes 0
            v *= 10;           // move to next place value
            index++;           // increment digit count
        }

        return index; // return number of digits
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for which digits are to be counted");
        int n = sc.nextInt();

        System.out.println(countdigit(n));
    }
}
