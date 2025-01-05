package com.priyakdey.algoexpert.arrays;

import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class ValidateSubsequence {

    // use two pointers to iterate over two arrays.

    public static boolean isValidSubsequence(List<Integer> array,
                                             List<Integer> sequence) {
        if (array.size() < sequence.size()) {
            return false;
        }
        int j = 0;
        for (Integer integer : array) {
            if (Objects.equals(integer, sequence.get(j))) {
                j++;
            }

            if (j == sequence.size()) {
                break;
            }
        }

        return j == sequence.size();
    }

}
