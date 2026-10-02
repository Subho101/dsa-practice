package com.subho.dsa.tree;

public class MaximumPathSum {

    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPath(root);
        return maxSum;
    }

    public static int maxPath(TreeNode root) {

        if (root == null)
            return 0;

        int leftSum = Math.max(0, maxPath(root.left));
        int rightSum = Math.max(0, maxPath(root.right));

        System.out.println("node" + root.val + " left sum " + leftSum + " right " + rightSum);
        // This can use BOTH left and right because this is the
        // path that ends at the current node.
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);

        // But when returning to the parent, we can only take ONE side.
        return root.val + Math.max(leftSum, rightSum);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        maxPathSum(root);
        System.out.println(maxSum);
    }
}
