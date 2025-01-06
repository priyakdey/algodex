package com.priyakdey.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class FourNumberSum {

    // extension of three sum problem

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> quadruplets = new ArrayList<Integer[]>();
        Arrays.sort(array);

        for (int i = 0, length = array.length; i < length - 3; i++) {
            if (i > 0 && array[i] == array[i- 1]) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && array[j] == array[j - 1]) {
                    continue;
                }

                int k = j + 1, l = length - 1;
                while (k < l) {
                    if (k > j + 1 && array[k] == array[k-1]) {
                        k++;
                        continue;
                    }

                    int sum = array[i] + array[j] + array[k] + array[l];
                    if (sum == targetSum) {
                        quadruplets.add(new Integer[]{array[i], array[j],
                                array[k], array[l]});
                        k++;
                    } else if (sum < targetSum) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return quadruplets;
    }

}
