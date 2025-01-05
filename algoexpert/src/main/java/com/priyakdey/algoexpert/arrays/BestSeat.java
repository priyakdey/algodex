package com.priyakdey.algoexpert.arrays;

/**
 * @author Priyak Dey
 */
public class BestSeat {

    // find the indices of maximum range of continuous zeroes.

    public int bestSeat(int[] seats) {
        int left = -1, right = -1;
        int maxRange = 0;

        int cursor = 1;
        while (cursor < seats.length) {
            if (seats[cursor] == 0) {
                int start = cursor;
                while (seats[cursor] == 0) {
                    cursor++;
                }
                int range = cursor - start;
                if (range > maxRange) {
                    maxRange = range;
                    left = start;
                    right = cursor - 1;
                }
            }
            cursor++;
        }

        return maxRange != 0 ? left + (right - left) / 2 : -1;
    }

}
