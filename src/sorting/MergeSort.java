package sorting;

import java.util.Arrays;
import java.util.List;

/**
 *
 * File is created by andreychernenko at 13.09.2025
 *
 *
 */


public class MergeSort {

    List<Integer> resSet = Arrays.asList(0, 1, 2, 9, 8, 2, 5, 6, 7, 4, 2, 6);


    public static int[] mergeSort(int[] list) {
        if(list.length <= 1) {
            return list;
        }
        int half = list.length / 2;
        int[] left = new int[half];
        int[] right = new int[half];
        System.arraycopy(list, 0, left, 0, list.length / 2);
        System.arraycopy(list, list.length / 2, right, 0, list.length / 2);
        left = mergeSort(left);
        right = mergeSort(right);
        return mergeSortOrdered(left, right);
    }

    public static int[] mergeSortOrdered(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(mergeSort(new int[]{0, 1, 2, 9, 8, 2, 5, 6, 7, 4, 2, 6})).forEach(System.out::println);
    }
}
