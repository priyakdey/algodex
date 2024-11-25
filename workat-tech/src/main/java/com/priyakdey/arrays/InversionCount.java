package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class InversionCount {

    int getInversionCount(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    int sort(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        return sort(array, start, mid)
                + sort(array, mid + 1, end)
                + merge(array, start, mid, mid + 1, end);
    }

    private int merge(int[] array, int leftStart, int leftEnd, int rightStart
            , int rightEnd) {
        int leftLength = leftEnd - leftStart + 1;
        int rightLength = rightEnd - rightStart + 1;

        int[] mergedArray = new int[leftLength + rightLength];

        int left = leftStart, right = rightStart;
        int curr = 0;
        int inversionCount = 0;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                mergedArray[curr++] = array[left++];
            } else {
                mergedArray[curr++] = array[right++];
                inversionCount += leftEnd - left + 1;
            }
        }

        while (left <= leftEnd) {
            mergedArray[curr++] = array[left++];
        }

        while (right <= rightEnd) {
            mergedArray[curr++] = array[right++];
        }

        curr = 0;
        left = leftStart;
        right = rightStart;

        while (left <= leftEnd) {
            array[left++] = mergedArray[curr++];
        }

        while (right <= rightEnd) {
            array[right++] = mergedArray[curr++];
        }

        return inversionCount;
    }

}
