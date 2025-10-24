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
        int left = 0;                // start of the window
        int max = 0;                 // max substring length found
        Map<Character, Integer> map = new HashMap<>();  // stores last seen index of each char

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If char was seen before and is inside current window,
            // move the left pointer right after its last seen position
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }

            // store or update last seen index of this char
            map.put(c, right);

            // update max length (current window = right - left + 1)
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
