**
 * Q3. Toggle the kth bit of a number
 * Approach:
 * 1. Create a mask by left-shifting 1 by k positions.
 * 2. Use bitwise XOR with the number to flip the kth bit.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        int number = sc.nextInt();
        System.out.println("Enter the bit you want to toggle");
        int k = sc.nextInt();
        System.out.println("The number after toggling the bit is " + 
                toggleBit(number,k));
    }

    public static int toggleBit(int number, int k){
        int mask = 1 << k;       // create mask with 1 at kth position
        return number ^ mask;    // toggle the kth bit
    }
}
