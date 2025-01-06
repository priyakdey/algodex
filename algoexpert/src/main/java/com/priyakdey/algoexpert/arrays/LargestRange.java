package com.priyakdey.algoexpert.arrays;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Priyak Dey
 */
public class LargestRange {

    // use a set to determine if a number in a range is present in the array

    public static int[] largestRange(int[] array) {
        Set<Integer> set =
                IntStream.of(array).boxed().collect(Collectors.toSet());

        int largestRange = 0;
        int left = -1, right = -1;

        for (int num : array) {
            if (set.contains(num)) {
                int l = num;
                while (set.contains(l)) {
                    set.remove(l);
                    l--;
                }

                int r = num + 1;
                while (set.contains(r)) {
                    set.remove(r);
                    r++;
                }

                int range = (r - 1) - (l + 1) + 1;
                if (range > largestRange) {
                    largestRange = range;
                    left = l + 1;
                    right = r - 1;
                }
            }
        }

        return new int[]{left, right};
    }

}
