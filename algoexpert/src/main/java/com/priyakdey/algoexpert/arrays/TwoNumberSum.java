package com.priyakdey.algoexpert.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class TwoNumberSum {

    // Use a Set for quick look back at already visited numbers

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> visited = new HashSet<>(array.length);

        for (int num : array) {
            int compliment = targetSum - num;
            if (visited.contains(compliment)) {
                return new int[]{num, compliment};
            }

            visited.add(num);
        }

        return new int[0];
    }

}
