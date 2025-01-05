package com.priyakdey.algoexpert.arrays;

/**
 * @author Priyak Dey
 */
public class SortedSquareArray {

    // use two pointers from extreme ends and fill new array from last position

    public int[] sortedSquaredArray(int[] array) {
        int length = array.length;
        int[] squaredArray = new int[length];
        int cursor = length - 1;
        int left = 0, right = length - 1;

        while (left <= right) {
            int x = array[left] * array[left];
            int y = array[right] * array[right];
            if (x >= y) {
                squaredArray[cursor--] = x;
                left++;
            } else {
                squaredArray[cursor--] = y;
                right--;
            }
        }

        return squaredArray;
    }

}
