package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * File is created by andreychernenko at 28.10.2025
 *
 *
 */


public class ArraysOddSum {
    /*
    *  Okay, that one failed :D, it actually walks through
    *  the list and gets all combinations (0 to n) with odd sum
    *  Leetcode wants a subarray
    *
    *  In computer science:
    *
    *  Subarray always means a contiguous slice of an array.
    *  Substring always means a contiguous slice of a string.
    *  Subsequence means elements kept in order, but not necessarily contiguous.
    *  Subset doesn’t care about order or contiguity.
    *
    *  arr = [1, 2, 3, 4]
    *
       | Expression  | Valid?
       | ----------- | -------------------------
       | `[2,3]`     | ✅ subarray, subsequence
       | `[1,3]`     | ❌ subarray, ✅ subsequence
       | `[3,1]`     | ❌ subsequence, ✅ subset
       | `[1,2,3,4]` | ✅ all of the above

    *
    *  https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
    * */
    public static int numOfSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        for(int m = 0; m < arr.length; m++) {
            int sum = 0;
            List<Integer> base = new ArrayList<>();
            for (int i = m; i < arr.length; i++) {
                base.add(arr[i]);
                sum += arr[i];
                if (base.size() == 1 && base.getFirst() % 2 > 0) {
                    result.add(base);
                    System.out.println(base);
                }
                for (int j = i + 1; j < arr.length; j++) {
                    base.add(arr[j]);
                    sum += arr[j];
                    if (sum % 2 > 0) {
                        result.add(base);
                        System.out.println(base);
                    }
                    base.removeLast();
                    sum -= arr[j];
                }
            }
        }
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{1,2,3,4,5,6,7}));
    }
}
