package com.priyakdey.algoexpert.arrays;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class ArrayOfProducts {

    // calculate prefix and suffix products for each element.

    public int[] arrayOfProducts(int[] array) {
        int length = array.length;
        int prefixProduct = 1;
        int suffixProduct = 1;

        int[] products = new int[length];
        Arrays.fill(products, 1);

        int left = 1, right = length - 2;
        while (left < length) {
            prefixProduct *= array[left - 1];
            products[left] *= prefixProduct;
            left++;

            suffixProduct *= array[right + 1];
            products[right] *= suffixProduct;
            right--;
        }

        return products;
    }

}
