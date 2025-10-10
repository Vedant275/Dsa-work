import java.util.*;

/**
 * Q. Find two numbers in a sorted array whose sum equals a given target
 * Approach:
 * 1. Use two pointers — one starting from the beginning
 *    and one from the end of the array.
 * 2. Add the numbers at these two positions.
 * 3. If the sum equals the target, print the indices and stop.
 * 4. If the sum is smaller than the target, move the left pointer forward.
 * 5. If the sum is greater than the target, move the right pointer backward.
 * 6. If no such pair is found, print -1, -1.
 */

public class Main {
    static int[] arr1 = {-1, -1}; // default result if pair not found

    static void CheckTarget(int[] arr, int pos2, int target) {
        int pos1 = 0;
        int[] arr2 = {-1, -1}; // to store result

        // Traverse the array using two pointers
        while (pos1 < pos2) {
            int sum = arr[pos1] + arr[pos2];

            if (sum == target) {
                System.out.println("The indices are " + pos1 + "and " + pos2 );
                return;
            } else if (sum < target) {
                pos1++; // move left pointer forward
            } else {
                pos2--; // move right pointer backward
            }
        }

        // If no pair found
        for (int i = 0; i < 2; i++) {
            System.out.print(arr2[i]);
        }
    }

        public static void main(String[] args) {
            System.out.println("Enter the size of the array");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the target sum");
            int sum = sc.nextInt();
            // Input array elements
            for (int i = 0; i < n; i++) {
                System.out.println("Enter the number: " + (i + 1));
                arr[i] = sc.nextInt();
            }

            int pos2 = arr.length;
            CheckTarget(arr, (pos2 - 1), sum);
        }
}
