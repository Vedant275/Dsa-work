import java.util.Scanner;

/**
 * Q. Sort an array using Selection Sort
 * Approach:
 * Selection Sort works by repeatedly finding the smallest element
 * from the unsorted portion of the array and placing it at the beginning.
 * Steps:
 * 1. Start from the first position in the array.
 * 2. Assume the current element is the smallest.
 * 3. Compare it with all elements to the right.
 * 4. If a smaller element is found, swap it with the current one.
 * 5. Continue this for all positions until the array becomes sorted.
 */

public class Main {
    public static void selectionSort(int[] numbers) {
        // Loop through each element of the array (except the last one)
        for (int i = 0; i < numbers.length - 1; i++) {
            int minimum = numbers[i];
            for(int j = (i + 1); j < numbers.length ;j++) {
                if(numbers[j] < numbers[i]) {
                    minimum = numbers[j];
                }
                // swap if the minimum is larger
                if(minimum < numbers[i]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of values in the array: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        selectionSort(numbers);
        for(int k = 0 ;k < numbers.length; k++) {
            System.out.println(numbers[k]);
        }
    }
}
