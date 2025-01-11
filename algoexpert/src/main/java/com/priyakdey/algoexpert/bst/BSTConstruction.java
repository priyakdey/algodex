package com.priyakdey.algoexpert.bst;

/**
 * @author Priyak Dey
 */
public class BSTConstruction {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST[] nodes = find(value);
            BST parent = nodes[0];
            BST newNode = new BST(value);
            if (value < parent.value) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }

            return this;
        }

        public boolean contains(int value) {
            return find(value)[1] != null;
        }

        public BST remove(int value) {
            if (this.left == null && this.right == null) return this;

            BST[] nodes = find(value);
            BST parent = nodes[0];
            BST node = nodes[1];
            if (node == null) return this;

            if (node.left == null && node.right == null) {
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (node.left == null) {
                node.value = node.right.value;
                node.right = null;
            } else if (node.right == null) {
                node.value = node.left.value;
                node.left = null;
            } else {
                // TODO: complete this
            }

            return this;
        }

        private BST[] find(int value) {
            BST curr = this, parent = null;

            while (curr != null) {
                parent = curr;
                if (curr.value == value) {
                    break;
                } else if (value < curr.value) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            return new BST[] {parent, curr};
        }
    }

}
