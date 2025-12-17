import java.util.Scanner;
public class BubbleSort {

    static int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    static boolean checkSort(int[] numbers) {
        // function to check if the array is already sorted in ascending order
        for (int pos = 0; pos < numbers.length - 1; pos++) {
            if (numbers[pos] > numbers[pos + 1]) {
                return false;
            }
        }
        return true;
    }
        public static void main (String[]args) {
            // if array is already sorted, print it directly
            if (checkSort(numbers) == true){
                for (int j = 0; j < numbers.length; j++) {
                    System.out.println(numbers[j]);
                }
                return;
            } else {
                int temp;
                // bubble sort to sort array in ascending order
                for (int pos = 0; pos < numbers.length - 1; pos++) {
                    for (int i = 0; i < numbers.length - pos - 1; i++) {
                        if (numbers[i] > numbers[i + 1]) {
                            temp = numbers[i];
                            numbers[i] = numbers[i + 1];
                            numbers[i + 1] = temp;
                        }
                    }
                }
                for (int j = 0; j < numbers.length; j++) {
                    System.out.println(numbers[j]);
                }
            }
        }
    }


