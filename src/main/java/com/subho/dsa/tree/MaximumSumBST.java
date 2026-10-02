package com.subho.dsa.tree;

public class MaximumSumBST {

    private static int sum;

    static class NodeValue {
        public int minNode;
        public int maxNode;
        public int sum;

        NodeValue(int minNode, int maxNode, int sum) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.sum = sum;
        }
    }

    private static NodeValue helper(TreeNode root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        System.out.println("===================");
        System.out.println("Node: " + root.val + " left " + left.sum + " right " + right.sum);
        System.out.println("Is " + root.val + " valid? " + (left.maxNode < root.val && root.val < right.minNode));

        if (left.maxNode < root.val && root.val < right.minNode) {
            System.out.println("Valid. So will return " + "min " + Math.min(root.val, left.minNode));
            System.out.println("Valid. So will return " + "max " + Math.max(root.val, right.maxNode));
            System.out.println("Valid. So will return " + "sum " + (left.sum + right.sum + root.val));
        } else {
            System.out.println("Invalid. So will return " + "min " + Integer.MIN_VALUE);
            System.out.println("Invalid. So will return " + "max " + Integer.MAX_VALUE);
            System.out.println("Invalid. So will return " + "sum " + Math.max(left.sum, right.sum));
        }

        if (left.maxNode < root.val && root.val < right.minNode) {

            int currSum = left.sum + right.sum + root.val;
            sum = Math.max(currSum, sum); // Store the maximum BST sum seen so far, even if it comes from a smaller
                                          // subtree or a leaf. A larger valid BST may have a smaller sum because
                                          // negative values can reduce its total.

            return new NodeValue(
                    Math.min(root.val, left.minNode),
                    Math.max(root.val, right.maxNode),
                    currSum);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));

    }

    public static int maxSumBST(TreeNode root) {
        sum = 0;
        helper(root);
        return Math.max(0, sum);
    }

    public static void main(String[] args) {
        Integer[] arr = { 4, 8, null, 6, 1, 9, null, -5, 4, null, null, null, -3, null, 10 };
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(maxSumBST(root));
    }
}
