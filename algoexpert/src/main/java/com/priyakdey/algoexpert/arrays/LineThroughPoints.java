package com.priyakdey.algoexpert.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LineThroughPoints {

    // iterate over every pair and create a map of gradient and intercept.
    // this helps keep track of max points in a line.

    public int lineThroughPoints(int[][] points) {
        Map<Pair, Integer> lineMap = new HashMap<>();
        int maxPoints = 1;

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            int localMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dx = x2 - x1;
                int dy = y2 - y1;

                // Reduce (dy, dx) to its simplest form
                int gcd = gcd(dy, dx);
                dx /= gcd;
                dy /= gcd;

                // Handle negative gradient representation consistently
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                Pair pair = new Pair(dy, dx);
                lineMap.put(pair, lineMap.getOrDefault(pair, 1) + 1);
                localMax = Math.max(localMax, lineMap.get(pair));
            }

            maxPoints = Math.max(maxPoints, localMax);
            lineMap.clear();
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    private record Pair(int dy, int dx) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return dy == pair.dy && dx == pair.dx;
        }

        @Override
        public int hashCode() {
            return 31 * dy + dx;
        }
    }
}
