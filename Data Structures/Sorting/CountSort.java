/**
 *  Perform sorting of the array using count sort technique
 */
public class Main {
    public static void countSorting(int[] sample) {
        int max = sample[0];
        for (int i = 0; i < sample.length; i++) {
            // find the largest number of the array ( size the count array)
            if (max < sample[i]) {
                max = sample[i];
            }
        }
      
        int[] count = new int[max + 1];
         /* By using this loop we just count the number of digits that
             appear in our unsorted array */
        for (int j = 0; j < sample.length; j++) {
            count[(sample[j] % 100)]++;
        }
      
        // rebuild the sorted array based on frequency
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sample[index++] = i;
                count[i]--;
            }
        }
      
        for (int j = 0; j < sample.length; j++) {
            System.out.println(sample[j]);     // the sorted array is printed
        }
    }
    public static void main(String[] args) {
        int[] sample = {4, 70, 54, 23, 45};
        countSorting(sample);
    }
}
