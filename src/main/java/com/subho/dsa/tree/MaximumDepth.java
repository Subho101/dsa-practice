package com.subho.dsa.tree;

public class MaximumDepth {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int height = 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        height = Math.max(left, right) + 1;
        return height;
    }
}
