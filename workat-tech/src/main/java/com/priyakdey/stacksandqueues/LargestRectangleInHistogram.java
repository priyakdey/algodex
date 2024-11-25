package com.priyakdey.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class LargestRectangleInHistogram {

    int getLargestArea(int[] heights) {
        int length = heights.length;
        Deque<Pair> stack = new ArrayDeque<>(length);

        int[] rightBound = new int[length];
        Arrays.fill(rightBound, length - 1);
        for (int i = 0; i < length; i++) {
            int height = heights[i];
            while (!stack.isEmpty() && height < stack.peek().height) {
                Pair pair = stack.pop();
                rightBound[pair.index] = i - 1;
            }
            stack.push(new Pair(height, i));
        }


        stack.clear();

        int[] leftBound = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int height = heights[i];
            while (!stack.isEmpty() && height < stack.peek().height) {
                Pair pair = stack.pop();
                leftBound[pair.index] = i + 1;
            }
            stack.push(new Pair(height, i));
        }


        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            int width = (rightBound[i] - leftBound[i] + 1) * 1;
            int height = heights[i];
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;

    }

    private record Pair(int height, int index) {
    }

}
