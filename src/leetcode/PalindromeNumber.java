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

    // faster approach with math operations only
    public static boolean isPalindrome(int x) {
        if(x<0|| (x%10==0 && x!=0)) return false;
        int rev= 0;
        while(x>rev) {
            rev = rev*10 + x % 10;
            x=x/10;
        }
        return (x==rev)|| (x==rev/10);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
