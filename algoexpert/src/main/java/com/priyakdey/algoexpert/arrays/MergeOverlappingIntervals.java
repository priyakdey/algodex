package com.priyakdey.algoexpert.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class MergeOverlappingIntervals {

    // sort the intervals and accumulate them in a separate array.
    // compare last interval from array and current interval from given input
    // to merge or append the intervals into the new array.

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals,
                Comparator.comparingInt((int[] a) -> a[0]).thenComparing(a -> a[1]));
        int length = intervals.length;
        int[][] mergedIntervals = new int[length][2];
        mergedIntervals[0] = intervals[0];
        int cursor = 0;

        for (int i = 1; i < length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            int prevStart = mergedIntervals[cursor][0];
            int prevEnd = mergedIntervals[cursor][1];

            int start, end;

            if (currStart <= prevEnd) {
                start = prevStart;
                end = Math.max(prevEnd, currEnd);
            } else {
                start = currStart;
                end = currEnd;
                cursor++;
            }

            mergedIntervals[cursor][0] = start;
            mergedIntervals[cursor][1] = end;
        }

        int[][] result = new int[cursor + 1][2];
        System.arraycopy(mergedIntervals, 0, result, 0, cursor + 1);
        return result;
    }

}
