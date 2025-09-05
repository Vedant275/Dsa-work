import java.util.Scanner;

/**
 * Q. Find the exponential result of a number till a given number
 *    this program calculates the results of a number raised to a certain power
 */

public class Main {
    // Calculates the power of a number raised to a definite number recursively
    public static int power(int i, int k) {
        if (k < 1) {
            return 1;
        }
        return i * power(i, k - 1);         // recursive call
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base number: ");
        int base = sc.nextInt();

        System.out.print("Enter the exponent: ");
        int exponent = sc.nextInt();

        System.out.println(power(base, exponent));
    }
}
