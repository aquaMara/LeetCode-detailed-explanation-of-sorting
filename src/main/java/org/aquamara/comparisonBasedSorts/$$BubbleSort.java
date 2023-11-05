package org.aquamara.comparisonBasedSorts;

public class $$BubbleSort {

    public static void main(String[] args) {
        bubbleSort(new int[]{7,3,2,1,5,6,10,9,8});
    }

    public static void bubbleSort(int[] nums) {
        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    hasSwapped = true;
                }
            }
        }
    }

    public static void bubbleSort1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
