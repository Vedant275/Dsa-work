/**
* Q Optimise the power funtion
*/

public class PowerFunctionOptimesed {
    // Recursive method: O(log n)
        static long power ( long x, int n){
            if (n == 0) return 1;              // base case
            long half = power(x, n / 2);       // divide
            if (n % 2 == 0)                     // even exponent
                return half * half;
            else                                // odd exponent
                return x * half * half;
        }

        public static void main (String[]args){
            long x = 2;
            int n = 10;
            System.out.println(power(x, n));   // Output: 1024
        }

    }
// if even so (x^n/2) * 2
//if odd x * x^(n-1)
