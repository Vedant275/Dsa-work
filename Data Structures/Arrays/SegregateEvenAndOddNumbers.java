/**
 * Q. Segregate even and odd numbers in an array
 * Approach:
 * 1. Traverse the array once.
 * 2. Store all even numbers in one list and all odd numbers in another.
 * 3. After traversal, combine the odd numbers list after the even numbers list.
 * 4. Print the final arranged list.
 */

import java.util.*;

public class Main {
    public static void segregateEvenAndOdd(int arr1[]) {
        ArrayList<Integer> even = new ArrayList<Integer>(); // stores even numbers
        ArrayList<Integer> odd = new ArrayList<Integer>();  // stores odd numbers

        // Separate even and odd numbers
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % 2 == 0) {
                even.add(arr1[i]);
            } else {
                odd.add(arr1[i]);
            }
        }

        // Add odd numbers after even numbers
        for (int i = 0; i < odd.size(); i++) {
            even.add(odd.get(i));
        }

        // Print the final list
        for (int j = 0; j < even.size(); j++) {
            System.out.println(even.get(j));
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 6, 15, 43, 64}; // sample input
        segregateEvenAndOdd(arr1);
    }
}
