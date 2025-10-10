/**
 * Q1. Set the kth bit of a number
 * Approach:
 * 1. Create a mask by left-shifting 1 by k positions.
 * 2. Use bitwise OR with the number to set the kth bit to 1.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        int number = sc.nextInt();
        System.out.println("Enter the bit you want to set");
        int k = sc.nextInt();
        System.out.println("The number after setting the bit is " + setInteger(number,k));
    }

    public static int setInteger(int number, int k){
        int mask = 1 << k;       // create mask with 1 at kth position
        return number | mask;    // set the kth bit
    }
}
