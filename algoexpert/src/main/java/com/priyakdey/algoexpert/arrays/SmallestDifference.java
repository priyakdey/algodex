package com.priyakdey.algoexpert.arrays;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class SmallestDifference {

    // sort both arrays and use two pointers to find the closest pair

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int length1 = arrayOne.length, length2 = arrayTwo.length;
        int i = 0, j = 0;

        int[] elements = {arrayOne[i], arrayTwo[j]};

        while (i < length1 && j < length2) {
            int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
            int minDiff = Math.abs(elements[0] - elements[1]);
            if (diff < minDiff) {
                elements[0] = arrayOne[i];
                elements[1] = arrayTwo[j];
            }

            if (arrayOne[i] <= arrayTwo[j]) {
                i++;
            } else {
                j++;
            }
        }

        return elements;
    }

}
