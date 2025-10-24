package leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * File is created by andreychernenko at 24.10.2025
 *
 *
 */


public class LongestSubstringNoRepeat {
    /*
    * pwwkew -> wke
    *
    * */
    public static int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int max = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            l = Math.max(index[s.charAt(r)], l);
            max = Math.max(max, r - l + 1);
            index[s.charAt(r)] = r + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
