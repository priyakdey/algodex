package com.priyakdey.algoexpert.arrays;

/**
 * @author Priyak Dey
 */
public class SubarraySort {

    // iterate from both ends and capture the index where current element is not
    // overall min/max.

    public static int[] subarraySort(int[] array) {
        int length = array.length;

        int right = 0;
        int currMax = array[0];

        for (int i = 1; i < length; i++) {
            if (array[i] < currMax) {
                right = i;
            } else {
                currMax = array[i];
            }
        }

        int left = length - 1;
        int currMin = array[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (array[i] > currMin) {
                left = i;
            } else {
                currMin = array[i];
            }
        }

        if (right < left) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left, right};
        }
    }

}
