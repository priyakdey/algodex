package com.priyakdey.algoexpert.recursion;

/**
 * @author Priyak Dey
 */
public class StaircaseTraversal {

    // use recursion to find the count. base case is either when height == 0
    // or height < 0. This is simpler using DP, whose solution is given below.

    public int staircaseTraversal(int height, int maxSteps) {
        if (height == 0) return 1;
        if (height < 0) return 0;

        int count = 0;

        for (int step = 1; step <= maxSteps; step++) {
            count += staircaseTraversal(height - step, maxSteps);
        }

        return count;
    }

}
