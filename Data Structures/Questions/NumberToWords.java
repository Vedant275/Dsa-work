import java.util.*;

/**
 * Q. Convert number into words using Indian number system
 */

public class NumberToWords {

    static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"};

    static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};

    static String twoDigit(int n) {
        if (n < 20) return ones[n];
        return tens[n / 10] + (n % 10 != 0 ? " " + ones[n % 10] : "");
    }

    static String threeDigit(int n) {
        String word = "";
        if (n >= 100) {
            word += ones[n / 100] + " Hundred ";
            n %= 100;
        }
        if (n > 0) word += twoDigit(n);
        return word.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num == 0) {
            System.out.println("Zero");
            return;
        }

        // Stack to store parts of the number
        Stack<String> wordsStack = new Stack<>();

        // Crore
        int crore = num / 10000000;
        if (crore > 0) wordsStack.push(twoDigit(crore) + " Crore");
        num %= 10000000;

        // Lakh
        int lakh = num / 100000;
        if (lakh > 0) wordsStack.push(twoDigit(lakh) + " Lakh");
        num %= 100000;

        // Thousands
        int thousand = num / 1000;
        if (thousand > 0) wordsStack.push(twoDigit(thousand) + " Thousand");
        num %= 1000;

        // Hundreds (last 3 digits)
        if (num > 0) wordsStack.push(threeDigit(num));

        // Build final number in words
        StringBuilder result = new StringBuilder();
        while (!wordsStack.isEmpty()) {
            result.append(wordsStack.pop()).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
//| Step | Number | Action / Words Added                         | Stack After Push                     |
//        | ---- | ------ | -------------------------------------------- | ------------------------------------ |
//        | 1    | 580000 | Crore = 580000/1^7=0 → skip                  | []                                   |
//        | 2    | 580000 | Lakh = 580000/1^5=5 → "Five Lakh"            | ["Five Lakh"]                        |
//        | 3    | 80000  | Thousand = 80000/1000=80 → "Eighty Thousand" | ["Five Lakh", "Eighty Thousand"]     |
//        | 4    | 0      | Hundreds = 0 → skip                          | ["Five Lakh", "Eighty Thousand"]     |
//        | 5    | —      | Pop stack to build result                    | result = "Five Lakh Eighty Thousand" |
