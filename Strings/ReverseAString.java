import java.util.*;
/**
 * Q. Check if a string is a palindrome using recursion
 * Approach:
 * 1. Convert the string to lowercase for uniformity.
 * 2. Use two pointers: one starting at the beginning (j) and one at the end (i) of the string.
 * 3. Compare characters at these pointers.
 * 4. If they are equal, move the pointers inward and check recursively.
 * 5. If characters mismatch, return false.
 * 6. If pointers meet or cross, return true.
 */

public class ReverseAString {

    public static boolean palindrome(int i, int j, String sample) {
        sample = sample.toLowerCase(); // make string lowercase

        if (sample.charAt(i) != sample.charAt(j)) { // mismatch found
            return false;
        }

        if (j >= i) { // pointers have met or crossed, meaning palindrome
            return true;
        }

        // recursively check next inner characters
        return palindrome(i - 1, j + 1, sample);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word you want to check:");
        String sample = sc.next();

        int i = sample.length() - 1; // end pointer
        int j = 0;                    // start pointer

        System.out.println(palindrome(i, j, sample));
    }
}
