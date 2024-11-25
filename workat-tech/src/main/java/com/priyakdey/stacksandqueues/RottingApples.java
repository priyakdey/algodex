package com.priyakdey.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class RottingApples {

    int getDaysToRot(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int fresh = 0;
        int minDays = 0;
        Deque<Tuple> queue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    fresh++;
                } else if (grid[row][col] == 2) {
                    queue.offer(new Tuple(row, col, 0));
                }
            }
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int row = tuple.row, col = tuple.col, days = tuple.days;
            minDays = Math.max(minDays, days);

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < rows
                        && newCol >= 0 && newCol < cols
                        && grid[newRow][newCol] == 1) {
                    queue.offer(new Tuple(newRow, newCol, days + 1));
                    grid[newRow][newCol] = 2;
                    fresh--;
                }
            }
        }

        return fresh == 0 ? minDays : -1;
    }

    private record Tuple(int row, int col, int days) {
    }

}
