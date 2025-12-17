import java.util.*;

/**
 * Q. Heap Sort using Array-based Binary Heap
 *
 * Approach:
 * 1. Build a max heap from the array.
 * 2. Swap the root (largest) with the last element.
 * 3. Reduce heap size and heapify the root.
 * 4. Repeat until array is sorted.
 */

public class heapSort {

    // Heapify subtree rooted at index i
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1));
            arr[i] = sc.nextInt();
        }

        heapSort(arr);

        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
