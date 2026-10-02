package com.subho.dsa.tree;

public class BalancedBinaryTree {

    static class Pair {
        boolean balanced;
        int ht;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) > 1)
            return false;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if (!left || !right)
            return false;
        return true;
    }

    public static Pair isBalancedOpt(TreeNode root) {
        if (root == null) {
            Pair p = new Pair();
            p.balanced = true;
            p.ht = 0;
            return p;
        }

        Pair lp = isBalancedOpt(root.left);
        Pair rp = isBalancedOpt(root.right);

        Pair curr = new Pair();
        curr.balanced = lp.balanced && rp.balanced && Math.abs(lp.ht - rp.ht) <= 1;
        curr.ht = Math.max(lp.ht, rp.ht) + 1;

        return curr;

    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

}
