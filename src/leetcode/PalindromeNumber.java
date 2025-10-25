package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * File is created by andreychernenko at 25.10.2025
 * <a href="https://leetcode.com/problems/palindrome-number/description/">...</a>
 *
 */


public class PalindromeNumber {

    // String operations -> toString -> iterating from 2 sides
    // Filling set by digits -> set.size() > ceil(x.length / 2) -> palindrome
    public static boolean isPalindrome(int x) {
        String stringX = String.valueOf(x);
        int length = stringX.length();
        if(x < 0 || (x%10==0 && x!=0)){
            return false;
        }
        if (x < 10) {
            return true;
        }
        else {
            for(int i = 0, j = length - 1; i < (double) (length - 1) / 2; i++, j--) {
                if (stringX.charAt(i) != stringX.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
