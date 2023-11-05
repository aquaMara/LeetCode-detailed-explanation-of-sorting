package org.aquamara.comparisonBasedSorts;

import java.util.Arrays;

// Height Checker
// 11/5/2023
// https://leetcode.com/explore/learn/card/sorting/694/comparison-based-sorts/4484/
public class $$HeightChecker {

    public static void main(String[] args) {
        int i = heightChecker(new int[]{1, 1, 4, 2, 1, 3});
        int i1 = heightChecker(new int[]{5, 1, 2, 3, 4});
        int i2 = heightChecker(new int[]{1, 2, 3, 4, 5});
    }

    public static int heightChecker(int[] heights) {
        int[] actual = Arrays.copyOf(heights, heights.length);
        boolean sorted = true;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] > heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    sorted = true;
                }
            }
        }
        int wrong = 0;
        for (int i = 0; i < actual.length; i++) {
            if (actual[i] != heights[i])
                ++wrong;
        }
        return wrong;
    }

    public static int heightChecker11(int[] heights) {
        // the first height that can be is 1,the last height is 100
        int[] heightsCounter = new int[101];
        for (int height : heights) {
            ++heightsCounter[height];
        }

        int wrongHeight = 0;
        int index = 1;
        for (int height : heights) {
            while (heightsCounter[index] == 0)
                ++index;

            if (index != height)
                ++wrongHeight;

            --heightsCounter[index];

        }
        return wrongHeight;
    }

    public static int heightChecker1(int[] heights) {
        // the first height that can be is 1,the last height is 100
        int[] heightsCounter = new int[101];
        int wrongHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            int i1 = heights[i];
            ++heightsCounter[heights[i]];
        }
        int index = 1;
        for (int i = 0; i < heights.length; i++) {
            while (heightsCounter[index] == 0)
                ++index;

            if (index != heights[i])
                ++wrongHeight;

            --heightsCounter[index];

        }
        return wrongHeight;
    }
}

/*
A school is trying to take an annual photo of all the students.
The students are asked to stand in a single file line in non-decreasing order by height.
Let this ordering be represented by the integer array expected where expected[i]
is the expected height of the ith student in line.
You are given an integer array heights representing the current order that the students are standing in.
Each heights[i] is the height of the ith student in line (0-indexed).
Return the number of indices where heights[i] != expected[i].

Example 1:
Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation:
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.

Example 2:
Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.

Example 3:
Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.

Constraints:
1 <= heights.length <= 100
1 <= heights[i] <= 100
*/
