package com.priyakdey.algoexpert.recursion;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class InterweavingStrings {

    // use three pointers to make a decision if char from one or two string
    // is a match or both and then recurse down the strings.

    // TODO: convert this into tabular solution

    public static boolean interweavingStrings(String one, String two,
                                              String three) {
        int length1 = one.length();
        int length2 = two.length();
        if (length1 + length2 != three.length()) {
            return false;
        }

        Boolean[][] cache = new Boolean[length1 + 1][length2 + 1];
        return interweavingStrings(one, 0, two, 0, three, 0, cache);
    }

    private static boolean interweavingStrings(String one, int index1,
                                               String two, int index2,
                                               String three, int index3,
                                               Boolean[][] cache) {
        if (index3 == three.length()) {
            return index1 == one.length() && index2 == two.length();
        }

        if (index1 == one.length()) {
            return Objects.equals(two.substring(index2),
                    three.substring(index3));
        }

        if (index2 == two.length()) {
            return Objects.equals(one.substring(index1),
                    three.substring(index3));
        }


        if (cache[index1][index2] != null) {
            return cache[index1][index2];
        }

        boolean matchesOne = one.charAt(index1) == three.charAt(index3);
        boolean matchesTwo = two.charAt(index2) == three.charAt(index3);
        boolean isInterweaving;

        if (!matchesOne && !matchesTwo) {
            isInterweaving = false;
        } else if (matchesOne && !matchesTwo) {
            isInterweaving = interweavingStrings(one, index1 + 1, two, index2,
                    three, index3 + 1, cache);
        } else if (!matchesOne) {
            isInterweaving = interweavingStrings(one, index1, two, index2 + 1,
                    three, index3 + 1, cache);
        } else {
            isInterweaving = interweavingStrings(one, index1 + 1, two, index2,
                    three, index3 + 1, cache)
                    || interweavingStrings(one, index1, two, index2 + 1,
                    three, index3 + 1, cache);
        }

        cache[index1][index2] = isInterweaving;
        return isInterweaving;
    }
}
