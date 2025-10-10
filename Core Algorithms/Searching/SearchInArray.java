/**
 * Q. Search for an element in an array using Linear Search
 * Approach:
 * 1. Traverse each element of the array one by one.
 * 2. If the element matches the number, print that it is found.
 * 3. If no match is found after the full loop, print that it is not found.
 */

import java.util.Scanner;

public class Main {

    public static boolean searchInArray(int number[], int value) {
        for (int j = 0; j < number.length; j++) {
            if (number[j] == value) {
                System.out.println("Value is found at index: " + j);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements do you want to add in the array");
        int n = sc.nextInt();
        int number[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            number[i] = sc.nextInt();
        }

        System.out.print("Enter the number you want to search: ");
        int value = sc.nextInt();
        System.out.println("It is " + searchInArray(number,value) + " that the element is founded");

    }
}
