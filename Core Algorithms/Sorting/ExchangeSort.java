import java.util.Scanner;

/**
 * Q. Sort user-input numbers using the Exchange Sort algorithm.
 * Approach:
 * 1. Use nested loops (Exchange Sort) to compare every pair of elements.
 *    - If an element at a smaller index is greater than
 *      one at a higher index, swap them.
 */

public class Main {
    public static void exchangeSort(int number[]) {
        // outer loop till second last element
        for (int j = 0; j < number.length - 1; j++ ) {
            // inner loop compares current element with the rest
            for (int k = j + 1; k < number.length; k++) {
                // swap if elements are out of order
                if (number[j] > number[k]) {
                    int temp = number[j];
                    number[j] = number[k];
                    number[k] = temp;
                }
            }
        }
    }

    public static void printSortedArray(int number[]) {
        for(int g = 0; g < number.length; g++){
            System.out.println(number[g]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many numbers you want to sort: ");
        int n = sc.nextInt();

        int number[] = new int[n];

        for (int i = 0; i < n; i++){
            System.out.println("Enter the number" + (i + 1));
            number[i] = sc.nextInt();
        }
        exchangeSort(number);
        printSortedArray(number);
    }
}
