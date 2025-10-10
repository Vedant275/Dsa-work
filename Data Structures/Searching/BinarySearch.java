import java.util.Scanner;

/**
 * Q. Search for an element in an array using Binary Search
 * Approach:
 * 1. Sort the array using Bubble Sort.
 * 2. Ask the user for the number to search.
 * 3. Use Binary Search to find the number:
 *    - Compare the middle element.
 *    - If it matches, print index.
 *    - If smaller, search right half.
 *    - If larger, search left half.
 */

public class Main {

    // Function to sort the array using Bubble Sort
    public static void bubbleSort(int[] number) {
        for (int pos = 0; pos < number.length - 1; pos++) {
            for (int i = 0; i < number.length - pos - 1; i++) {
                if (number[i] > number[i + 1]) {
                    int temp = number[i];
                    number[i] = number[i + 1];
                    number[i + 1] = temp;
                }
            }
        }
    }

    // Function to perform Binary Search
    public static void binarySearch(int[] number, int value) {
        int low = 0;
        int high = number.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2; // Find middle index

            if (number[mid] == value) {
                System.out.println("The value is found at index: " + mid);
                found = true;
                break;
            } else if (number[mid] < value) {
                low = mid + 1;  // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        if (!found) {
            System.out.println("The value is not found in the array.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] number = new int[6];

        for (int j = 0; j < 6; j++) {
            System.out.print("Enter number " + (j + 1) + ": ");
            number[j] = sc.nextInt();
        }
        // Sort the array before searching
        bubbleSort(number);

        System.out.println("Enter the number you want to search: ");
        int value = sc.nextInt();

        binarySearch(number, value); // Perform binary search
    }
}
