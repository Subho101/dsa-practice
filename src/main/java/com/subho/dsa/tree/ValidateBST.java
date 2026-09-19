package com.subho.dsa.tree;

public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long min, long max) {
        System.out.println("MIN " + min + " MAX " + max);
        if (root == null)
            return true;

        if (root.val < min || root.val > max)
            return false;

        return root.val > min && root.val < max && isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        // Integer[] arr = { 5, 4, 6, null, null, 3, 7 };
        Integer[] arr = { 2, 1, 3 };
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(isValidBST(root));
    }
}
