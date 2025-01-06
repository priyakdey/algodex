package com.priyakdey.algoexpert.arrays;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class NonConstructibleChange {

    // run a cumulative sum on a sorted array. If at any point, the
    // cumulative sum + 1 < current coin, we cannot make cumulative sum + 1.

    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int cannotMake = 0;
        for (int coin : coins) {
            if (cannotMake + 1 < coin) break;
            cannotMake += coin;
        }

        return cannotMake + 1;
    }

}
