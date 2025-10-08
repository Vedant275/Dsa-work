import java.util.*;

/**
 *  Q. Check if the word is a palindrome using recursion
 */

public class Main {

    public static boolean checkPalindrome(String word, int i, int j) {
        // Base case: if pointers cross, it's a palindrome
        if (i >= j) {
            return true;
        }

        // If mismatch found, not a palindrome
        if (word.charAt(i) != word.charAt(j)) {
            return false;
        }

        // Recursive call to move towards the middle
        return checkPalindrome(word, i + 1, j - 1);
    }

    public static void main(String[] args) {
        System.out.println("Type the word that has to be checked for palindrome:");
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        // convert to lowercase for uniform comparison
        String wordLowerCase = word.toLowerCase();

        boolean result = checkPalindrome(wordLowerCase, 0, wordLowerCase.length() - 1);

        if (result)
            System.out.println(word + " is a palindrome.");
        else
            System.out.println(word + " is not a palindrome.");
    }
}
