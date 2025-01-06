package com.priyakdey.algoexpert.arrays;

/**
 * @author Priyak Dey
 */
public class MinRewards {

    // iterate from left and increase rewards, if current score > prev score.
    // iterate from right and increase rewards, if current score > prev score.
    // take max of rewards from each iteration.

    public static int minRewards(int[] scores) {
        int length = scores.length;
        int[][] rewards = new int[length][2];

        rewards[0][0] = 1;
        for (int i = 1; i < length; i++) {
            if (scores[i] < scores[i - 1]) {
                rewards[i][0] = 1;
            } else {
                rewards[i][0] = rewards[i - 1][0] + 1;
            }
        }

        rewards[length - 1][1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            if (scores[i] < scores[i + 1]) {
                rewards[i][1] = 1;
            } else {
                rewards[i][1] = rewards[i + 1][1] + 1;
            }
        }

        int totalRewards = 0;
        for (int i = 0; i < length; i++) {
            totalRewards += Math.max(rewards[i][0], rewards[i][1]);
        }

        return totalRewards;
    }

}
