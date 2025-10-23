package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * File is created by andreychernenko at 23.10.2025
 *
 *
 */

/*
* Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
* */
public class TwoSum {
    /*
    * get first number in outer loop
    * iterate through inner loop, we'll get all possible pairs of numbers
    * when first loop is done, increment outer loop index
    * if pair sum = target -> add to result list
    * */
    public static int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length;i++){
            for(int j = 0; j < nums.length;j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
