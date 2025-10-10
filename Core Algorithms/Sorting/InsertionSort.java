import java.util.Scanner;

/**
 * Q. Write a program to sort an array using the Insertion Sort algorithm.
 *
 * Approach:
 * 1. Start from the second element (index 1) and insert it
 *    into the correct position in the sorted part of the array
 *    (which is initially just the first element).
 * 2. For each element, compare it with previous elements and shift the greater ones
 *    to the right until the correct spot is found.
 * 3. Repeat until the array is sorted in ascending order.
 */

public class Main {

    public static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int prev = i - 1;

            // Shift elements of the sorted part to the right
            while (prev >= 0 && numbers[prev] > current) {
                numbers[prev + 1] = numbers[prev];
                prev--;
            }

            // Place the current element in its correct position
            numbers[prev + 1] = current;
        }
    }

    public static void printArray(int[] numbers) {
        System.out.println("Sorted array:");
        for (int num : numbers) {
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

        insertionSort(numbers);
        printArray(numbers);
    }
}
