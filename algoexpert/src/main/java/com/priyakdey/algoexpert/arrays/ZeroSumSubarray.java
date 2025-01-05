package com.priyakdey.algoexpert.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class ZeroSumSubarray {

    // keep a track of seen sums, and check if curr cumm sum == any prev sum.

    public boolean zeroSumSubarray(int[] nums) {
        int sum = 0;
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (num == 0) {
                return true;
            }

            sum += num;
            if (sum == 0 || seen.contains(sum)) {
                return true;
            }
            seen.add(sum);
        }

        return false;
    }

}
