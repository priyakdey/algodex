package com.priyakdey.algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class Powerset {

    // use recursion to generate all the subsequences and capture them.

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<Integer> buf = new ArrayList<>(array.size());
        List<List<Integer>> acc = new ArrayList<>();
        acc.add(new ArrayList<>());
        powerset(array,0, buf, acc);
        return acc;
    }

    private static void powerset(List<Integer> array, int index,
                                 List<Integer> buf, List<List<Integer>> acc) {
        if (index == array.size()) {
            return;
        }

        powerset(array, index + 1, buf, acc);

        buf.add(array.get(index));
        acc.add(new ArrayList<>(buf));
        powerset(array, index + 1, buf, acc);
        buf.removeLast();
    }
}
