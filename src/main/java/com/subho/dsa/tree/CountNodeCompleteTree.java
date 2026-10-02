package com.subho.dsa.tree;

public class CountNodeCompleteTree {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        if (lh == rh)
            return ((int) Math.pow(2, lh)) - 1;

        return countNodes(root.left) + countNodes(root.right) + 1;

    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;

        while (node.left != null) {
            height++;
            node = node.left;
        }

        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;

        while (node.right != null) {
            height++;
            node = node.right;
        }

        return height;
    }
}
