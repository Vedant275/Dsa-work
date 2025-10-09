/**
 * Q. Write a program to sort an array using the Merge Sort algorithm.
 * Approach:
 * 1. Divide the array into two halves recursively until each 
 *    subarray contains only one element.
 * 2. Merge the two sorted halves by comparing elements 
 *    from both and arranging them in order.
 * 3. Continue merging up the recursion tree until the whole array is sorted.
 */

public class Main {
    static int[] arr = {46, 35, 24, 665, 54};

    public static void main(String[] args) {
        mergeSort(arr, 0, arr.length - 1);  // Call merge sort on the entire array

        System.out.println("Sorted array:");
        for (int l = 0; l < arr.length; l++) {
            System.out.println(arr[l]);
        }
    }

    // Recursive method to divide the array
    static void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;  // Base case: single element is already sorted
        }

        int mid = (start + end) / 2;

        // Divide into two halves
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);

        // Merge the sorted halves
        merge(array, start, mid, end);
    }

    // Merge two sorted halves
    static void merge(int[] array, int start, int mid, int end) {
        // Create temporary arrays for left and right halves
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[start + i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = array[mid + 1 + j];
        }

        // Merge them back into the main array
        int i = 0, j = 0, k = start;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy any remaining elements from left[]
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy any remaining elements from right[]
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
