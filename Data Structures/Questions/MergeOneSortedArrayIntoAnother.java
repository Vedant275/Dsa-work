import java.util.*;

/**
 * Q. Merge one sorted array into another (using counting method)
 * Approach:
 * 1. Find the greatest element from both arrays (for count array size).
 * 2. Count occurrences of each element using a frequency array.
 * 3. Rebuild a merged sorted array using the count array.
 */


public class Main {
    // The greatest element is founded by this method
    public static int greatestElement(int arr1[], int arr2[], int max) {
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] > max) {
                max = arr1[i];
            }
        }
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr1[i];
            }
        }
        return max;
    }

    // Merges two sorted arrays into one sorted array using counting technique
    public static void mergedSortedArray(int arr1[], int arr2[], int max) {
        int count[] = new int[max + 10];
        for (int j = 0; j < arr1.length; j++) {
            count[arr1[j]]++;
        }
        for (int j = 0; j < arr1.length; j++) {
            count[arr2[j]]++;
        }
        int index = 0;
        for (int l = 1; l < count.length; l++) {
            if (count[l] != 0) {
                arr2[index] = l;
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.println(arr2[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("the number of elements you want to enter in array 1");
        int n = sc.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[2 * n];
        // Taking inputs of array 1 and 2
        System.out.println("Type the elements of the array 1 one by one");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the number" + (i + 1));
            arr1[i] = sc.nextInt();
        }
        System.out.println("Type the elements of the array 2 one by one");
        for (int i = 0; i < (2 * n); i++) {
            System.out.println("Enter the number" + (i + 1));
            arr2[i] = sc.nextInt();
        }
        int max = greatestElement(arr1, arr2, arr1[0]);
        greatestElement(arr1, arr2, max);
        mergedSortedArray(arr1, arr2, max);
    }
}
