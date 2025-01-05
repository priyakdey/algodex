package com.priyakdey.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class ThreeNumberSum {

    // post sorting, use nested loops to find the triplets.
    // use a previous element look back mechanism to avoid duplicates.


    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int length = array.length;

        List<Integer[]> triplets = new ArrayList<>();

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            int left = i + 1, right = length - 1;
            while (left < right) {
                if (left > i + 1 && array[left] == array[left - 1]) {
                    left++;
                    continue;
                }

                int sum = array[i] + array[left] + array[right];
                if (sum == targetSum) {
                    triplets.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                } else if (sum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }

}
