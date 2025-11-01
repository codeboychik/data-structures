package leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * File is created by andreychernenko at 01.11.2025
 *
 * <a href="https://leetcode.com/problems/calculate-amount-paid-in-taxes">...</a>
 *
 * Round using BigDecimal is not necessary
 */


public class CalculateAmountOfTaxes {
    public static double calculateTax(int[][] brackets, int income) {
        double result = 0.0;
        if(income == 0) return result;
        for(int i = 0; i < brackets.length && income > 0; i++) {
            int upper = brackets[i][0];
            int tax = brackets[i][1];
            if (i == 0) {
                result += (Math.min(upper, income)) * ((double) tax / 100);
                income -= upper;
            } else {
                int lower = brackets[i - 1][0];
                result += (Math.min(upper - lower, income)) * ((double) tax / 100);
                income -= upper - lower;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{new int[]{3,50}, new int[]{7,10}, new int[]{12,25}};
        int[][] test2 = new int[][]{new int[]{1,0}, new int[]{4,25}, new int[]{5,50}};
        int[][] test3 = new int[][]{new int[]{2,50}};

        System.out.println(calculateTax(test1, 10));
        System.out.println(calculateTax(test2, 2));
        System.out.println(calculateTax(test3, 0));
    }
}
