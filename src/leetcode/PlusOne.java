package leetcode;

import java.util.Arrays;

/**
 *
 * File is created by andreychernenko at 25.10.2025
 * <a href="https://leetcode.com/problems/plus-one/description/">...</a>
 *
 */


public class PlusOne {

    public static int[] plusOne(int[] digits) {
        boolean carry = false;
        for(int i = digits.length - 1; i >= 0 || carry; i--) {
            if (i == digits.length - 1 || carry) digits[i] += 1; carry = false;
            if (digits[i] / 10 == 1) {
                carry = true;
                digits[i] %= 10;
            }
            if (carry && i == 0) {
                int[] newDigits = new int[digits.length + 1];
                for (int j = 1; j < digits.length; j++) {
                    newDigits[j] = digits[j-1];
                }
                digits = newDigits;
                i += 1;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9,9,9,9,9,9,9})));
    }

}
