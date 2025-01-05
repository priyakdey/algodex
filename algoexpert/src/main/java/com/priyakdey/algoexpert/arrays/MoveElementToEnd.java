package com.priyakdey.algoexpert.arrays;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class MoveElementToEnd {

    // use two pointers left and right, and swap elements if needed

    public static List<Integer> moveElementToEnd(List<Integer> array,
                                                 int toMove) {
        int left = 0, right = array.size() - 1;

        while (left < right) {
            if (Objects.equals(array.get(left), toMove) && Objects.equals(array.get(right), toMove)) {
                right--;
            } else if ((Objects.equals(array.get(left), toMove) && !Objects.equals(array.get(right), toMove))) {
                Collections.swap(array, left, right);
                left++;
                right--;
            } else if (!Objects.equals(array.get(left), toMove) && Objects.equals(array.get(right), toMove)) {
                left++;
                right--;
            } else {
                left++;
            }
        }

        return array;
    }

}
