package leetcode;

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
        //String head = s.substring(0,1);
        StringBuilder worm = new StringBuilder();
        int max = 0;
        for(int i = 0; i < s.length();i++){
            worm.append(s.charAt(i));
            max = worm.length() > max ? max + 1: max;
            for (int j = i + 1; j < s.length(); j++) {
                String next = s.substring(j, j+1);
                if (!worm.toString().contains(next)) {
                    worm.append(next);
                    max = worm.length() > max ? max + 1: max;
                    if(s.length() - j == 1) {
                        worm = new StringBuilder();
                    }
                } else {
                    if (worm.length() > max) {
                        System.out.println(worm);
                        max = worm.length();
                    }
                    worm = new StringBuilder();
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
