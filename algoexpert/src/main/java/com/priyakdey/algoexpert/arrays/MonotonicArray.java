package com.priyakdey.algoexpert.arrays;

import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * @author Priyak Dey
 */
public class MonotonicArray {

    // define two predicates, and iterate over the array to check if
    // only one of them holds true for all elements.

    public static boolean isMonotonic(int[] array) {
        Objects.requireNonNull(array);

        if (array.length <= 1) return true;

        BiPredicate<Integer, Integer> nonIncreasingPredicate =
                (prev, curr) -> curr <= prev;
        BiPredicate<Integer, Integer> nonDecreasingPredicate =
                (prev, curr) -> curr >= prev;

        int curr = 1;
        while (curr < array.length && array[curr - 1] == array[curr]) {
            curr++;
        }

        if (curr == array.length) return true;

        BiPredicate<Integer, Integer> predicate = array[curr] < array[curr - 1]
                ? nonIncreasingPredicate
                : nonDecreasingPredicate;

        while (curr < array.length && predicate.test(array[curr - 1],
                array[curr])) {
            curr++;
        }

        return curr == array.length;
    }

}
