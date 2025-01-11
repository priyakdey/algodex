package com.priyakdey.algoexpert.arrays;

import java.util.function.BiPredicate;

/**
 * @author Priyak Dey
 */
public class LongestPeak {

    public static int longestPeak(int[] array) {
        int longestPeak = 0;

        BiPredicate<Integer, Integer> increasing = (curr, next) -> curr < next;
        BiPredicate<Integer, Integer> decreasing = (curr, next) -> curr > next;

        int length = array.length;
        int curr = 0;

        while (curr < length - 1) {
            int start = curr;
            while (curr < length - 1
                    && increasing.test(array[curr], array[curr + 1])) {
                curr++;
            }
            if (curr == length - 1 || array[curr] == array[curr + 1]) {
                curr++;
                continue;
            }

            while (curr < length - 1
                    && decreasing.test(array[curr], array[curr + 1])) {
                curr++;
            }
            if (curr != length - 1 && array[curr] == array[curr + 1]) {
                curr++;
                continue;
            }

            int peak = curr - start + 1;
            if (peak > 3 && peak > longestPeak) {
                longestPeak = peak;
            }
        }

        return longestPeak;
    }
}
