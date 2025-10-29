package leetcode;

/**
 *
 * File is created by andreychernenko at 29.10.2025
 *
 * <a href="https://leetcode.com/problems/max-consecutive-ones">...</a>
 */

public class MostConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int max = 0;
        for (int num : nums) {
            counter = num == 1 ? counter + 1 : 0;
            max = max < counter ? counter: max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1,0,1,1}));
    }
}
