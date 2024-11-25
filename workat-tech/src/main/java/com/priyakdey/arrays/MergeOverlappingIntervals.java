package com.priyakdey.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class MergeOverlappingIntervals {

    int[][] mergeIntervals(int[][] intervals) {
        Comparator<int[]> compareFn = Comparator.comparingInt(
                (int[] arr) -> arr[0]).thenComparing(arr -> arr[1]);
        Arrays.sort(intervals, compareFn);

        int[][] merged = new int[intervals.length][2];
        merged[0] = intervals[0];
        int cursor = 0;

        for (int i = 1; i < intervals.length; i++) {
            int prevStart = merged[cursor][0];
            int prevEnd = merged[cursor][1];

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            int start, end;

            if (currStart <= prevEnd) {
                start = prevStart;
                end = Math.max(prevEnd, currEnd);
            } else {
                cursor++;
                start = currStart;
                end = currEnd;
            }

            merged[cursor][0] = start;
            merged[cursor][1] = end;
        }

        int[][] mergedIntervals = new int[cursor + 1][2];

        System.arraycopy(merged, 0, mergedIntervals, 0, cursor + 1);
        return mergedIntervals;
    }

}
