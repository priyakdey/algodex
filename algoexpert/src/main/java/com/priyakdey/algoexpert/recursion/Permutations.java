package com.priyakdey.algoexpert.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class Permutations {

    // swap elements at an index and i, where i = [index + 1, length)
    // and then recurse for the same operation for index + 1

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> accumulator = new ArrayList<>();
        if (array.isEmpty()) {
            return accumulator;
        }

        generatePermutations(array, 0, accumulator);
        return accumulator;
    }

    private static void generatePermutations(List<Integer> array, int index,
                                             List<List<Integer>> accumulator) {
        if (index == array.size()) {
            accumulator.add(new ArrayList<>(array));
            return;
        }

        generatePermutations(array, index + 1, accumulator);

        for (int i = index + 1; i < array.size(); i++) {
            Collections.swap(array, index, i);
            generatePermutations(array, index + 1, accumulator);
            Collections.swap(array, index, i);
        }
    }

}
