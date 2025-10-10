import java.util.*;

    /**
     * Q. Return a pair of numbers from an array whose sum equals the target
     * Approach:
     * 1. Traverse the array once.
     * 2. For each element arr[i], calculate requiredNumber = target - arr[i].
     * 3. Check if requiredNumber already exists in the HashMap.
     *    - If yes, return the pair [requiredNumber, arr[i]].
     *    - If no, store arr[i] in the HashMap for future lookup.
     * 4. If no such pair is found after full traversal, return [-1, -1].
     */
    
    public class Main {
    static int[] returnPairWithSum(int[] arr, int target) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int requiredNumber = target - arr[i];
            if (map.containsKey(requiredNumber)) {
                return new int[]{requiredNumber, arr[i]};
            }
            map.put(arr[i], true);
        }
        return new int[]{-1, -1};
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

        int target = 6;  // Example target
        int[] result = returnPairWithSum(arr, target);

        if (result[0] != -1) {
            System.out.println("Pair found: " + result[0] + " " + result[1]);
        } else {
            System.out.println("No pair found with sum " + target);
        }
    }
}

/* Example:
   target = 11
   arr = [5, 7, 3, 9, 1, 4, 2]

   Step-by-step:
   i | arr[i] | requiredNumber | map contains? 
   0 |   5    |      6         |     No        
   1 |   7    |      4         |     No        
   2 |   3    |      8         |     No        
   3 |   9    |      2         |     No        
   4 |   1    |     10         |     No        
   5 |   4    |      7         |    Yes        
*/
