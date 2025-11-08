package leetcode;

import java.util.Arrays;

/**
 *
 * File is created by andreychernenko at 04.11.2025
 * <a href="https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/">...</a>
 *
 */


public class OnesZerosDiffInMatrix {
    public static int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] onesRow = new int[m], onesCol = new int[n];

        // Count 1s in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }

        // Build result using formula
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int zerosRow = n - onesRow[i];
                int zerosCol = m - onesCol[j];
                result[i][j] = onesRow[i] + onesCol[j] - zerosRow - zerosCol;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(onesMinusZeros(new int[][]{new int[]{0, 1, 1}, new int[]{1, 0, 1}, new int[]{0, 0, 1}})));
        System.out.println(Arrays.deepToString(onesMinusZeros(new int[][]{new int[]{1,1,1}, new int[]{1,1,1}})));
        System.out.println(Arrays.deepToString(onesMinusZeros(new int[][]{new int[]{1,1}, new int[]{1,1}, new int[]{1,1}})));
        System.out.println(Arrays.deepToString(onesMinusZeros(new int[][]{new int[]{1,1,1,0}, new int[]{1,1,1,0}, new int[]{1,0,1,0}})));
    }
}
