package com.priyakdey.algoexpert.arrays;

/**
 * @author Priyak Dey
 */
public class FirstDuplicateValue {

    // use the index as map to track if element has been visited before.

    public int firstDuplicateValue(int[] array) {
        int value = -1;

        for (int i = 0; i < array.length; i++) {
            int val = Math.abs(array[i]);
            if (array[val - 1] < 0) {
                value = val;
                break;
            }
            array[val - 1] *= -1;
        }

        return value;
    }

}
