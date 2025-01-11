package com.priyakdey.algoexpert.bst;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class KthLargestValueInBst {

    // start iterating from the rightmost leaf node and decrement k

    public int findKthLargestValueInBst(BST tree, int k) {
        if (k < 1) throw new IllegalArgumentException("expected k >= 1");

        BST curr = tree;
        Deque<BST> stack = new ArrayDeque<>();

        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }

        while (!stack.isEmpty() && k > 1) {
            curr = stack.pop();
            k--;

            BST child = curr.left;
            while (child != null) {
                stack.push(child);
                child = child.right;
            }
        }

        if (stack.isEmpty()) {
            throw new IllegalArgumentException("not enough nodes");
        }

        return stack.peek().value;
    }

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }


}
