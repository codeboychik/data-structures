package leetcode;

/**
 *
 * File is created by andreychernenko at 26.10.2025
 *
 *
 */


public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = 0;
        while(i < j) {
            int newArea = (j - i) * (Math.min(height[i], height[j]));
            if (area <= newArea) area = newArea;
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{2,3,4,5,18,17,6}));
        System.out.println(maxArea(new int[]{1,2,3,1000,9}));
        System.out.println(maxArea(new int[]{8,7,2,1}));
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
    }
}
