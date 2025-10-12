import java.util.*;

/**
 * Q.Recursion of sum of first n natural numbers
 */

public class Main {
    // Calcualate the sum of natural numbers from 1 upto given number n
    public static int sumUpTo(int i) {
        // when n becomes 0 recursion stops
        if(i < 0){
            return 0;
        }
        return i + sumUpTo(i - 1);    
    }
    
    public static void main(String[] args) {
        System.out.println("Enter the number till which you want the sum");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println( sumUpTo(i));
    }
}
/* 2 method
    public static int sumUpTo(int i) {
        //solving using ternary operator
        return (i <= 0) ? 0 : i + sumUpTo(i - 1);    
    }
/*
Dry Run of sumUpto(n) using ternary operator (n <= 0):

Call | n  | Expression
-----------------------------
  1  |  4 | 4 + sumUpto(3)
  2  |  3 | 3 + sumUpto(2)
  3  |  2 | 2 + sumUpto(1)
  4  |  1 | 1 + sumUpto(0)
  5  |  0 | 0
*/
