package leetcode;
import java.util.*;

/**
 *
 * File is created by andreychernenko at 01.11.2025
 *
 *
 */


public class MinVerticesNumToReachAllNodes {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIncoming = new boolean[n];

        // Mark nodes with incoming edges
        for (List<Integer> edge : edges) {
            hasIncoming[edge.get(1)] = true;  // edge.get(1) is the destination
        }

        // Collect nodes with no incoming edges
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasIncoming[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> test1 = List.of(List.of(0,1), List.of(0,2), List.of(2,5), List.of(3,4), List.of(4,2)); // 6
        List<List<Integer>> test2 = List.of(List.of(0,1), List.of(2,1), List.of(3,1), List.of(1,4), List.of(2,4)); // 5
        List<List<Integer>> test3 = List.of(List.of(1,2), List.of(3,2), List.of(1,3), List.of(1,0), List.of(0,2), List.of(0,3));
        System.out.println(findSmallestSetOfVertices(4, test3));
    }
}
