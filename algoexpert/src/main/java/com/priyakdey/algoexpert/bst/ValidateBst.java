package com.priyakdey.algoexpert.bst;

/**
 * @author Priyak Dey
 */
public class ValidateBst {

    // Traverse down the tree and compare the node value with min/max till now.
    // when going left, min = min and max = node.value.
    // when going right, min = node.value and max = max.

    public static boolean validateBst(BST tree) {
        return validateBst(tree, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validateBst(BST node, long min, long max) {
        if (node == null) return true;
        if (node.value < min || node.value >= max) return false;

        return validateBst(node.left, min, node.value)
                && validateBst(node.right, node.value, max);
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
