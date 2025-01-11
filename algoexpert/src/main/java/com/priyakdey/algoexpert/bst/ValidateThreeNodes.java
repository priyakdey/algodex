package com.priyakdey.algoexpert.bst;

/**
 * @author Priyak Dey
 */
public class ValidateThreeNodes {

    // check which one nodeOne or nodeThree is the descendant. Whichever is the
    // one, check the other one if ancestor.

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        BST descendant = findDescendant(nodeOne, nodeTwo, nodeThree);
        if (descendant == null) return false;

        return descendant == nodeOne ? isAncestor(nodeThree, nodeTwo) :
                isAncestor(nodeOne, nodeTwo);
    }

    private BST findDescendant(BST nodeOne, BST nodeTwo, BST nodeThree ) {
        boolean oneIs = false;
        BST curr = nodeTwo;
        while (curr != null) {
            if (curr.value == nodeOne.value) {
                oneIs = true;
                break;
            } else if (nodeOne.value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        boolean threeIs = false;
        curr = nodeTwo;
        while (curr != null) {
            if (curr.value == nodeThree.value) {
                threeIs = true;
                break;
            } else if (nodeThree.value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if ((oneIs && threeIs) || (!oneIs && !threeIs)) {
            return null;
        } else if (oneIs) {
            return nodeOne;
        } else {
            return nodeThree;
        }
    }

    private boolean isAncestor(BST ancestor, BST descendant) {
        BST curr = ancestor;
        while (curr != null) {
            if (curr.value == descendant.value) {
                return true;
            } else if (descendant.value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return false;
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
