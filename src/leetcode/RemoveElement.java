package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * File is created by andreychernenko at 25.10.2025
 *
 *
 */
// [3,2,3,3] -> 0, 2, 3 -> 4

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int k = 0; // index for next "keep" position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        //System.out.println(removeElement(new int[]{4,1,2,4,4,0,0}, 4));
        System.out.println(removeElement(new int[]{1}, 1));
    }
}
