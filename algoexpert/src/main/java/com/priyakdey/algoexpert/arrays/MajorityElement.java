package com.priyakdey.algoexpert.arrays;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class MajorityElement {

    // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm

    public int majorityElement(int[] array) {
        int majorityElement = array[0];
        int bias = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == majorityElement) {
                bias++;
            } else {
                bias--;
            }

            if (bias == 0) {
                majorityElement = array[i];
                bias = 1;
            }
        }

        int count = 0;
        for (int num : array) {
            if (num == majorityElement) {
                count++;
            }
        }

        return count > array.length / 2 ? majorityElement : -1;
    }

}
