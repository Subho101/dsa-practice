package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class RootToNode {
    public static List<Integer> solve(TreeNode root, int val) {
        List<Integer> ans = new ArrayList<>();
        getPath(root, val, ans);
        return ans;
    }

    private static boolean getPath(TreeNode root, int val, List<Integer> ans) {
        if (root == null)
            return false;

        ans.add(root.val);
        if (root.val == val)
            return true;

        if (getPath(root.left, val, ans) || getPath(root.right, val, ans))
            return true;

        ans.remove(ans.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, null, 5 };
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(solve(root, 5));
    }
}
