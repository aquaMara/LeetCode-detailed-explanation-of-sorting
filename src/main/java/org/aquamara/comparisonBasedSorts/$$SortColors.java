package org.aquamara.comparisonBasedSorts;

// Sort Colors
// 10/31/2023
// https://leetcode.com/explore/learn/card/sorting/694/comparison-based-sorts/4483/
public class $$SortColors {

    public static void main(String[] args) {
        sortColors(new int[]{0,1,1,0,2,1,1,2});
        sortColors(new int[]{1,0,2,1,2,1,0});
        sortColors(new int[]{2,0,2,1,1,0});
        sortColors(new int[]{2,0,1});
    }

    // Quick sort
    public static void sortColors(int[] nums) {
        int start = 0;  // stands for the next place of 0
        int end = nums.length - 1;  // stands for the next place of 2
        int index = 0;

        while (index <= end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                ++start;
                ++index;
            } else if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                --end;
            } else {
                ++index;
            }
        }
    }

    public static void sortColors1(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        for (int num : nums) {
            if (num == 0)
                ++zeroes;
            else if (num == 1)
                ++ones;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroes != 0) {
                nums[i] = 0;
                --zeroes;
            } else if (ones != 0) {
                nums[i] = 1;
                --ones;
            } else {
                nums[i] = 2;
            }
        }

    }
}

/*
Given an array nums with n objects colored red, white, or blue, sort them in-place
so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
*/
