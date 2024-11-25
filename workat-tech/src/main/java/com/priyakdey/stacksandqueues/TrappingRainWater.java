package com.priyakdey.stacksandqueues;

/**
 * @author Priyak Dey
 */
public class TrappingRainWater {

    int volumeOfTrappedRainWater(int[] heights) {
        int length = heights.length;

        int[] leftBound = new int[length];
        int[] rightBound = new int[length];

        leftBound[0] = heights[0];
        for (int i = 1; i < length; i++) {
            leftBound[i] = Math.max(leftBound[i - 1], heights[i]);
        }

        rightBound[length - 1] = heights[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightBound[i] = Math.max(rightBound[i + 1], heights[i]);
        }

        int width = 1;
        int totalVolume = 0;

        for (int i = 1; i < length - 1; i++) {
            int boundHeight = Math.min(leftBound[i], rightBound[i]);
            int heightDiff = boundHeight - heights[i];
            if (heightDiff > 0) {
                totalVolume += heightDiff * width;
            }
        }

        return totalVolume;
    }

}
