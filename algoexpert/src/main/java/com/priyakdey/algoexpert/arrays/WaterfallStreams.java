package com.priyakdey.algoexpert.arrays;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class WaterfallStreams {

    public double[] waterfallStreams(double[][] array, int source) {
        int rows = array.length;
        int cols = array[0].length;
        double[] buckets = new double[cols];

        Deque<Tuple> queue = new ArrayDeque<>();
        queue.offer(new Tuple(0, source, 100.0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int row = tuple.row;
            int col = tuple.col;
            double volume = tuple.volume;

            if (row == rows - 1) {
                buckets[col] += volume;
                continue;
            }

            if (array[row + 1][col] == 0) {
                queue.offer(new Tuple(row + 1, col, volume));
            } else {
                int left = col - 1;
                while (left >= 0 && array[row + 1][left] != 0 && array[row][left] == 0) {
                    left--;
                }
                if (left >= 0 && array[row + 1][left] == 0) {
                    queue.offer(new Tuple(row + 1, left, volume / 2));
                }

                int right = col + 1;
                while (right < rows && array[row + 1][right] != 0 && array[row][right] == 0) {
                    right++;
                }
                if (right < rows && array[row + 1][right] == 0) {
                    queue.offer(new Tuple(row + 1, right, volume / 2));
                }
            }
        }

        return buckets;
    }

    private record Tuple(int row, int col, double volume) {
    }

    public static void main(String[] args) {
        double[][] array = {
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}
        };
        double[] doubles = new WaterfallStreams().waterfallStreams(array, 3);
        System.out.println(Arrays.toString(doubles));
    }

}
