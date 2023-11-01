package org.aquamara.comparisonBasedSorts;

public class $$SelectionSort {

    public static void main(String[] args) {
        selectionSort(new int[]{4, 2, 3, 4, 1});
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
