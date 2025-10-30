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
        Map<String, Integer> freq = new HashMap<>();
        for (String s : nums) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for (String a : nums) {
            if (target.startsWith(a)) {
                String b = target.substring(a.length());
                count += freq.getOrDefault(b, 0);
                if (a.equals(b)) count--; // avoid pairing same index
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numOfPairs(new String[]{"777","7","77","77"}, "7777"));
        System.out.println(numOfPairs(new String[]{"1","1"}, "11"));
        System.out.println(numOfPairs(new String[]{"2","2","2"}, "22"));
        System.out.println(numOfPairs(new String[]{"123","4","12","34"}, "1234"));
        System.out.println(numOfPairs(new String[]{"74","1","67","1","74"}, "174"));
    }

}
