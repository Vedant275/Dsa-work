/**
 * Q. Remove a given substring from a string
 * Approach:
 * 1. Take the main string and the substring to remove as input.
 * 2. Find the index of the substring in the main string.
 * 3. Extract parts of the main string before and after the substring.
 * 4. Concatenate these parts to form the result string.
 * 5. Print the final string.
 */

import java.util.Scanner;

public class StringReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the main string:");
        String main = sc.nextLine();

        System.out.println("Enter the substring to remove:");
        String remove = sc.nextLine();

        // Find the starting index of the substring
        int index = main.indexOf(remove);

        if (index != -1) { // substring exists
            // Extract part before and after the substring
            String result = main.substring(0, index) + main.substring(index + remove.length());
            System.out.println("The remaining string is: " + result);
        } else {
            System.out.println("Substring not found in the main string.");
        }
    }
}
