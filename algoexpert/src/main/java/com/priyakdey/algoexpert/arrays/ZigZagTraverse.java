package com.priyakdey.algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Priyak Dey
 */
public class ZigZagTraverse {

    // simply understand the movement and the edge cases when the pointer
    // goes outside the range.

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        int rows = array.size();
        int cols = array.getFirst().size();
        int length = rows * cols;

        List<Integer> result = new ArrayList<>(length);
        int cursor = 0;
        int row = 0, col = 0;
        boolean isDown = true;
        while (cursor < length) {
            result.add(array.get(row).get(col));
            cursor++;

            if (isDown) {
                row = row + 1;
                col = col - 1;
            } else {
                row = row - 1;
                col = col + 1;
            }

            if (col < 0 && row < rows) {
                col = 0;
                isDown = !isDown;
            } else if (row < 0 & col < cols) {
                row = 0;
                isDown = !isDown;
            } else if (row > rows - 1 && col < 0) {
                row = rows - 1;
                col = 1;
                isDown = !isDown;
            } else if (row < 0 && col > cols - 1) {
                row = 1;
                col = cols - 1;
                isDown = !isDown;
            } else if (row > rows - 1) {
                row = rows - 1;
                col = col + 2;
                isDown = !isDown;
            } else if (col > cols - 1) {
                row = row + 2;
                col = cols - 1;
                isDown = !isDown;
            }
        }

        return result;
    }

}
