/**
 * Q. Find two distinct indices whose elements sum to the given target value.
 */

import java.util.*;

public class Main {
    static int[] arr1 = {-1, -1};

    static void checktargetNumber(int[] arr, int v) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == v) {             // check if sum equals target
                    System.out.println("Indices with values equal to " + v + " are: " + i + " and " + j);
                    return;
                }
            }
        }
        // if no pair found
        System.out.println(arr1[0] + "," + arr1[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }
        checktargetNumber(arr, 10);  // target value
    }
}
