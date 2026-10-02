package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.Collections;

public class BoundaryTraversal {
    public static ArrayList<Integer> boundaryTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeaf(root))
            ans.add(root.val);
        addLeftBoundary(root, ans);
        addLeafNodes(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }

    private static void addLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode curr = root.left;

        while (curr != null) {
            if (!isLeaf(curr))
                ans.add(curr.val);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    private static void addRightBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode curr = root.right;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr))
                tmp.add(curr.val);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        Collections.reverse(tmp);
        ans.addAll(tmp);
    }

    private static void addLeafNodes(TreeNode root, ArrayList<Integer> ans) {
        if (isLeaf(root)) {
            ans.add(root.val);
            return;
        }

        if (root.left != null)
            addLeafNodes(root.left, ans);
        if (root.right != null)
            addLeafNodes(root.right, ans);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, null, null, 8, 9, null, null, null, null };
        TreeNode root = TreeNode.buildTree(arr);
        ArrayList<Integer> ans = boundaryTraversal(root);
        System.out.println(ans);
    }
}
