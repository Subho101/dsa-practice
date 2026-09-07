package com.subho.dsa.tree;

public class Symmetric {
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetricUtil(root.left, root.right);
    }

    private static boolean isSymmetricUtil(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null)
            return node1 == node2;

        if (node1.val != node2.val)
            return false;

        return isSymmetricUtil(node1.left, node2.right) && isSymmetricUtil(node1.right, node2.left);
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 2, 3, 4, 4, 3 };
        // Integer[] arr = { 1, 2, 2, null, 3, null, 3 };
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(isSymmetric(root));
    }

}
