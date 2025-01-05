package com.priyakdey.algoexpert.bst;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class FindClosestValueInBST {

    // iterate like a binary search in a bst, and capture the closest
    // value on every node visit.

    public static int findClosestValueInBst(BST tree, int target) {
        Objects.requireNonNull(tree);
        BST curr = tree;
        int closestValue = tree.value;

        while (curr != null) {
            if (target == curr.value) {
                closestValue = curr.value;
                break;
            } else {
                if (Math.abs(target - curr.value) < Math.abs(target - closestValue)) {
                    closestValue = curr.value;
                }

                curr = target < curr.value ? curr.left : curr.right;
            }
        }

        return closestValue;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
