import java.util.Scanner;

/**
 * Q. Sort an array using Quick Sort (beginner-friendly version)
 * Approach:
 * 1. Pick the last element of the current array segment as the "divider".
 * 2. Move all smaller numbers to the left of the divider and larger numbers to the right.
 * 3. Recursively repeat the same steps on the left and right parts of the array until sorted.
 */

public class Main {

    // Function to place the divider in the correct position
    public static int divideArray(int[] arr, int start, int end) {
        // last element chosen as divider
        int divider = arr[end];
        // keeps track of where smaller numbers go
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] < divider) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place divider in the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1; // return the divider’s final position
    }

    // Quick Sort recursive function
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int position = divideArray(arr, start, end); // find divider position
            quickSort(arr, start, position - 1);  // sort left segment
            quickSort(arr, position + 1, end);    // sort right segment
        }
    }

    // Print the sorted array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to sort: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        quickSort(numbers, 0, numbers.length - 1);
        System.out.println("\nSorted array:");
        printArray(numbers);
    }
}
