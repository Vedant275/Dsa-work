/**
 * Q4. Check the value of the kth bit
 * Approach:
 * 1. Create a mask by left-shifting 1 by k positions.
 * 2. Use bitwise AND with the number.
 * 3. If result is 0, the bit is 0; otherwise, the bit is 1.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        int number = sc.nextInt();
        System.out.println("Enter the bit you want to check");
        int k = sc.nextInt();
        System.out.println("The value of the bit is " + checkBit(number,k));
    }

    public static int checkBit(int number, int k){
        int mask = number & (1 << k);  // isolate kth bit
        return (mask != 0) ? 1 : 0;    // return 1 if set, 0 otherwise
    }
}
