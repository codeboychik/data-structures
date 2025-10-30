package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * File is created by andreychernenko at 30.10.2025
 * <a href="https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/description/">...</a>
 *
 */


public class NumberOfConcatStringPairs {

    public static int numOfPairs(String[] nums, String target) {
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if((nums[i] + nums[j]).equals(target)) {
                count++;
                System.out.printf("(%d, %d) %s %s \n", i, j, nums[i], nums[j]);
            }
            if ((nums[j] + nums[i]).equals(target)) {
                count++;
                System.out.printf("(%d, %d) %s %s \n", j, i, nums[j], nums[i]);
            }
            j--;
            if (j - i == 0) {
                j = nums.length - 1;
                i++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        // System.out.println(numOfPairs(new String[]{"777","7","77","77"}, "7777"));
        // System.out.println(numOfPairs(new String[]{"1","1"}, "11"));
        // System.out.println(numOfPairs(new String[]{"2","2","2"}, "22"));
        // System.out.println(numOfPairs(new String[]{"123","4","12","34"}, "1234"));
        System.out.println(numOfPairs(new String[]{"74","1","67","1","74"}, "174"));
    }

}
