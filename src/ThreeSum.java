import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThreeSum {
    public static List<Integer> filterListWithMaxOccurrences(List<Integer> list, int maxOccurrences) {
        HashMap<Integer, Integer> occurrenceMap = new HashMap<>();
        List<Integer> filteredList = new ArrayList<>();

        for (int num : list) {
            int count = occurrenceMap.getOrDefault(num, 0);
            if (count < maxOccurrences) {
                filteredList.add(num);
                occurrenceMap.put(num, count + 1);
            }
        }

        return filteredList;
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> resSet = ConcurrentHashMap.newKeySet();

        List<Integer> numsf = filterListWithMaxOccurrences(Arrays.stream(nums).boxed().toList(), 3);

        Map<Integer, List<Integer>> numIndexMap = IntStream.range(0, numsf.size())
                .boxed()
                .collect(Collectors.groupingBy(numsf::get));

        IntStream.range(0, numsf.size())
            .parallel()
            .forEach(i -> IntStream.range(0, numsf.size())
                .parallel()
                .forEach(j -> {
                    int lastComplement = -(numsf.get(i) + numsf.get(j));
                    List<Integer> idxs = numIndexMap.get(lastComplement);
                    if (idxs != null) {
                        for (int idx : idxs) {
                            if (idx != i && idx != j && i != j) {
                                List<Integer> triplet = Stream.of(numsf.get(i), numsf.get(j), lastComplement).sorted().toList();
                                resSet.add(triplet);
                                break;
                            }
                        }
                    }
                })
            );
        return new ArrayList<>(resSet).stream().toList();
    }
}
