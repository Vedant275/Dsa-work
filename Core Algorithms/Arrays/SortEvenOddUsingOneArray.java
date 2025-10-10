/**
 * Approach: Using bit manipulation and bubble-swap logic to move
 *           all odd numbers to the right side of the array.
 */

public class Main {
    public static void sortEvenAndOddNumbers(int numbers[]) {
        int temp;
        for (int pos = 0; pos < numbers.length - 1; pos++) {
            for (int i = 0; i < numbers.length - pos - 1; i++) {
                // Check if the number is odd using bitwise AND
                if ((numbers[i] & 1) != 0) {
                    // Swap odd number to the right
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        sortEvenAndOddNumbers(numbers);
        for (int j = 0; j < numbers.length; j++) {
            System.out.println(numbers[j]);
        }
    }
}
