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
            Tuple current = queue.poll();
            int row = current.row;
            int col = current.col;
            double volume = current.volume;

            if (row == rows - 1) {
                buckets[col] += volume;
                continue;
            }

            if (array[row + 1][col] == 0) {
                Tuple leftTuple = new Tuple(row + 1, col, volume);
                queue.offer(leftTuple);
                System.out.printf("From %s to %s\n", current, leftTuple);
            } else {
                int left = col - 1;
                while (left >= 0 && array[row][left] != 0) {
                    left--;
                }
                if (left >= 0 && array[row][left] == 0) {
                    Tuple leftTuple = new Tuple(row + 1, left, volume / 2);
                    queue.offer(leftTuple);
                    System.out.printf("From %s to %s\n", current, leftTuple);
                }

                int right = col + 1;
                while (right < cols && array[row][right] != 0) {
                    right++;
                }
                if (right < cols && array[row][right] == 0) {
                    Tuple rightTuple = new Tuple(row + 1, right, volume / 2);
                    queue.offer(rightTuple);
                    System.out.printf("From %s to %s\n", current, rightTuple);
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
