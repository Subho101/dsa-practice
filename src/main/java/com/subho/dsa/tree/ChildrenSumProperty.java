package com.subho.dsa.tree;

public class ChildrenSumProperty {
    public static boolean isSumProperty(TreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        int leftChild = 0, rightChild = 0;

        if (root.left != null) {
            leftChild = root.left.val;
        }

        if (root.right != null) {
            rightChild = root.right.val;
        }

        return leftChild + rightChild == root.val && isSumProperty(root.left) && isSumProperty(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = { 10, 10 };
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(isSumProperty(root));
    }
}
