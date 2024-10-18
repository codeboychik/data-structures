import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> triplet = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            triplet.add(nums[i]);
            if(triplet.size() < 2) continue; // nothing to check yet, continue adding

            // iterating until array's length or triplet would be composed earlier
            for (int j = i + 1;
               !triplet.isEmpty()
               && j < nums.length
               || (triplet.size() == 3 && triplet.get(0) + triplet.get(1) + triplet.get(2) == 0); j++) {
                if (triplet.get(0) + triplet.get(1) + nums[j] == 0) {
                    triplet.add(nums[j]);
                    res.add(triplet);
                    triplet.clear();
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4}).forEach(x -> x.forEach(System.out::println));

    }
}
