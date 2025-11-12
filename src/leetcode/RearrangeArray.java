package leetcode;

import java.util.Arrays;

/**
 *
 * File is created by andreychernenko at 12.11.2025
 *
 *
 */


public class RearrangeArray {
    public static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int j = 0;
        int k = 1;
        for (int num : nums) {
            if (num > 0) {
                result[j] = num;
                j += 2;
                continue;
            }
            if (num < 0) {
                result[k] = num;
                k += 2;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        rearrangeArray(new int[]{3, 1, -2, -5, 2, -4});
        rearrangeArray(new int[]{-1, 1});
    }
}
