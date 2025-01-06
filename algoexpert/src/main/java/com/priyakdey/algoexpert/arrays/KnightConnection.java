package com.priyakdey.algoexpert.arrays;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class KnightConnection {

    // consider the board a graph and use BFS to move one knight to another.
    // total moves = distance / 2, if moves are odd, add one to it.

    public int knightConnection(int[] knightA, int[] knightB) {
        int startX = knightA[0], startY = knightA[1];
        int endX = knightB[0], endY = knightB[1];

        if (startX == endX && startY == endY) return 0;

        Deque<Tuple> queue = new LinkedList<>();
        Set<Tuple> visited = new HashSet<>();
        Tuple tuple = new Tuple(startX, startY, 0);
        queue.offer(tuple);
        visited.add(tuple);
        int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1},
                {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

        int distance = 0;

        while (!queue.isEmpty()) {
            tuple = queue.poll();
            int currX = tuple.x;
            int currY = tuple.y;
            int currDistance = tuple.distance;

            if (currX == endX && currY == endY) {
                distance = currDistance;
                break;
            };

            for (int[] direction : directions) {
                int nextX = currX + direction[0];
                int nextY = currY + direction[1];
                tuple = new Tuple(nextX, nextY, currDistance + 1);
                if (!visited.contains(tuple)) {
                    queue.offer(tuple);
                    visited.add(tuple);
                }
            }
        }

        return (distance & 1) == 0 ? distance / 2 : (distance / 2) + 1;
    }

    private record Tuple(int x, int y, int distance) {

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return x == tuple.x && y == tuple.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
