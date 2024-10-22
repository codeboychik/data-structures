import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> resSet = new HashSet<>();
        List<Integer> numList = Arrays.stream(nums).boxed().toList();
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        IntStream.range(0, nums.length)
            .parallel()
            .forEach(i -> IntStream.range(0, nums.length - 1)
                .parallel()
                .forEach(j -> {
                    int lastComplement = -(nums[i] + nums[j]);
                    int idx = numList.indexOf(lastComplement);
                    if (!set.contains(lastComplement) || idx == i || idx == j || i == j) return;
                    List<Integer> triplet = Stream.of(nums[i], nums[j], lastComplement).sorted().toList();
                    resSet.add(triplet);
                })
            );
        return new ArrayList<>(resSet).stream().filter(Objects::nonNull).toList()
                .stream().sorted((list1, list2) -> {
                    // Compare lists lexicographically (element by element)
                    for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                        int comparison = Integer.compare(list1.get(i), list2.get(i));
                        if (comparison != 0) {
                            return comparison;
                        }
                    }
                    // If all compared elements are equal, the shorter list should come first
                    return Integer.compare(list1.size(), list2.size());
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        threeSum(new int[]{-2,0,1,1,2}).forEach(x -> x.forEach(System.out::print));
    }
}
