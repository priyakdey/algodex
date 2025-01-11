package com.priyakdey.algoexpert.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class SameBSTs {

    // two BSTs are same if first element is same and length is same.
    // then capture all smaller elements in one array and greater than
    // equal elements in one array.
    // recursively check for both array for the above condition.

    public static boolean sameBsts(List<Integer> arrayOne,
                                   List<Integer> arrayTwo) {
        if (arrayOne.isEmpty() && arrayTwo.isEmpty()) return true;
        if (arrayOne.isEmpty() || arrayTwo.isEmpty()) return false;

        int sizeOne = arrayOne.size();
        int sizeTwo = arrayTwo.size();
        if (!Objects.equals(arrayOne.getFirst(), arrayTwo.getFirst())
                || sizeOne != sizeTwo) {
            return false;
        }

        List<Integer> smallerOne = new ArrayList<>();
        List<Integer> largerOne = new ArrayList<>();

        for (int i = 1; i < sizeOne; i++) {
            int num = arrayOne.get(i);
            if (num < arrayOne.getFirst()) {
                smallerOne.add(num);
            } else {
                largerOne.add(num);
            }
        }

        List<Integer> smallerTwo = new ArrayList<>();
        List<Integer> largerTwo = new ArrayList<>();

        for (int i = 1; i < sizeTwo; i++) {
            int num = arrayTwo.get(i);
            if (num < arrayTwo.getFirst()) {
                smallerTwo.add(num);
            } else {
                largerTwo.add(num);
            }
        }

        return sameBsts(smallerOne, smallerTwo)
                && sameBsts(largerOne, largerTwo);
    }

}
