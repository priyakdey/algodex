package com.priyakdey.algoexpert.arrays;

import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class ApartmentHunting {

    // iterate over every block, and capture the distance of each req
    // form that block using two pointers.

    public static int apartmentHunting(List<Map<String, Boolean>> blocks,
                                       String[] reqs) {
        int blockLength = blocks.size();
        int[] distances = new int[blockLength];

        for (int i = 0; i < blockLength; i++) {
            int totalDistance = 0;

            for (String req : reqs) {
                // assumption is every block has the requirements
                if (blocks.get(i).get(req)) {
                    continue;
                }

                int left = i - 1;
                while (left >= 0 && !blocks.get(left).get(req)) left--;
                int distance = left != -1 ? i - left + 1 : blockLength;

                int right = i + 1;
                while (right < blockLength && !blocks.get(right).get(req))
                    right++;
                distance = Math.min(distance, right != blockLength ?
                        right - i + 1 : blockLength);
                totalDistance = Math.max(totalDistance, distance);
            }

            distances[i] = totalDistance;
        }

        int index = -1;
        int minDistance = blockLength;
        for (int i = 0; i < blockLength; i++) {
            if (distances[i] < minDistance && distances[i] < blockLength) {
                minDistance = distances[i];
                index = i;
            }
        }

        return index;
    }

}
