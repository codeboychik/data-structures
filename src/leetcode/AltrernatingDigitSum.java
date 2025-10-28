package leetcode;

/**
 *
 * File is created by andreychernenko at 28.10.2025
 *
 *
 */


public class AltrernatingDigitSum {
    public static int alternateDigitSum(int n) {
        int length = String.valueOf(n).length();
        boolean positive = length % 2 > 0;
        int totalSum = 0;
        while(n / 10 > 0) {
           totalSum += positive ? n % 10: -(n % 10);
           positive = !positive;
           n /= 10;
        }
        return totalSum + n;
    }

    public static void main(String[] args) {
        System.out.println(alternateDigitSum(918273734));
    }
}
