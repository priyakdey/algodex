package com.priyakdey.algoexpert.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LongestSubarrayWithSum {

    // use a map to keep track of cumulative sum and its index.

    public int[] longestSubarrayWithSum(int[] array, int targetSum) {
        int length = array.length;
        Map<Integer, Integer> subarraySum = new HashMap<>(length + 1);
        subarraySum.put(0, -1);
        int longestLength = 0;
        int left = -1, right = -1;
        int currSum = 0;

        for (int i = 0; i < length; i++) {
            currSum += array[i];

            if (subarraySum.containsKey(currSum - targetSum)) {
                int index = subarraySum.get(currSum - targetSum);
                int subarrayLength = i - (index + 1) + 1;
                if (subarrayLength > longestLength) {
                    longestLength = subarrayLength;
                    left = index + 1;
                    right = i;
                }
            }

            int j = i;
            subarraySum.computeIfAbsent(currSum, _ -> j);
        }

        return longestLength != 0 ? new int[]{left, right} : new int[]{};
    }

}
