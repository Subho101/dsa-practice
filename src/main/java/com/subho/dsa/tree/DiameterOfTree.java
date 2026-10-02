package com.subho.dsa.tree;

public class DiameterOfTree {

    private static int maxH;

    public static int diameterOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;
        maxH = Integer.MIN_VALUE;
        height(root);
        return maxH;
    }

    public static void diameterOfBinaryTreeUtil(TreeNode root) {
        // Brute force
        if (root == null)
            return;
        int lh = height(root.left);
        int rh = height(root.right);

        System.out.println("MaxH " + maxH + " node " + root.val);
        System.out.println("current: " + (lh + rh));

        maxH = Math.max(maxH, lh + rh + 2); // adding 2 here for 2 edge connecting to root
        diameterOfBinaryTreeUtil(root.left);
        diameterOfBinaryTreeUtil(root.right);
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return -1; // Since counting edge instead of nodes
        }
        int left = height(node.left);
        int right = height(node.right);
        maxH = Math.max(maxH, left + right + 2); // Remove this to use in brute force
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);

        System.out.println(diameterOfBinaryTree(root));
    }
}
