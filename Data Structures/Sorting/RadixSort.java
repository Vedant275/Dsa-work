import java.util.*;

/**
 * Q. Sort an array using Radix Sort
 * Approach:
 * 1. Find the maximum number manually to know the number of digits.
 * 2. For each digit (units, tens, hundreds, etc.), sort the array using counting sort logic.
 * 3. Repeat for all digits until the array is fully sorted.
 */

public class Main {

    // Function to perform counting sort based on a specific digit
    public static void countingSortByDigit(int[] arr, int place) {
        int n = arr.length;
        int[] output = new int[n];    // output array
        int[] count = new int[10];    // count array for digits 0-9

        // count occurrences of each digit
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / place) % 10;
            count[digit]++;
        }

        // cumulative count to determine positions
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // copy sorted numbers back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Radix sort main function
    public static void radixSort(int[] arr) {
        // Find maximum number of the array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Apply counting sort for each digit
        for (int place = 1; max / place > 0; place *= 10) {
            countingSortByDigit(arr, place);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of values in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        radixSort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);

    }
}
