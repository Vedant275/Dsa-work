/**
 * Q. Check if an array is already sorted
 * Approach:
 * 1. Traverse the array from the beginning to the second-last element.
 * 2. Compare each element with the next one.
 * 3. If any element is greater than the next, the array is not sorted.
 * 4. If no such case is found, the array is sorted.
 */

import java.util.*;

public class Main {

    // Function to check if array is sorted in ascending order
    static boolean checkSort(int[] numbers) {
        for (int pos = 0; pos < numbers.length - 1; pos++) {
            if (numbers[pos] > numbers[pos + 1]) {
                return false;  // Array is not sorted
            }
        }
        return true;  // Array is sorted
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int numbers[] = new int[n];
        
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter the element " + (i + 1));
            numbers[i] = sc.nextInt();
        }

        // Check if array is sorted
        if (checkSort(numbers)) {
            System.out.println("The array is already sorted");
        } else {
            System.out.println("The array is not sorted");
        }
    }
}
