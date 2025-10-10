/**
 * Q2. Clear the kth bit of a number
 * Approach:
 * 1. Create a mask by left-shifting 1 by k positions.
 * 2. Take bitwise NOT of mask to get 0 at kth position.
 * 3. Use bitwise AND with the number to clear the kth bit.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        int number = sc.nextInt();
        System.out.println("Enter the bit you want to clear");
        int k = sc.nextInt();
        System.out.println("The number after clearing the bit is " + clearBit(number,k));
    }

    public static int clearBit(int number, int k){
        int mask = 1 << k;       // create mask with 1 at kth position
        return number & ~(mask); // clear the kth bit
    }
}
