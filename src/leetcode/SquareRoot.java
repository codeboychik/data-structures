package leetcode;

/**
 *
 * File is created by andreychernenko at 24.10.2025
 *
 *
 */


public class SquareRoot {

    // Newton formula
    public static int mySqrt(int x) {
        double step = 1;
        while (Math.round(((step + x/step) / 2) * ((step + x/step) / 2)) != x) {
            step += 1;
        }
        return (int) (step + x/step) / 2;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
        //System.out.println(10/100);
    }
}
