package com.priyakdey.algoexpert.recursion;

import java.util.List;

/**
 * @author Priyak Dey
 */
public class ProductSum {

    // use recursion to go down the depths of the nested lists

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    private static int productSum(List<Object> array, int depth) {
        int sum = 0;
        for (Object element: array) {
            if (element instanceof List list) {
                sum += productSum(list, depth + 1);
            } else {
                sum += (Integer) element;
            }
        }

        return sum * depth;
    }

}
