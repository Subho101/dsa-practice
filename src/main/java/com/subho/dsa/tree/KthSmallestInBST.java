package com.subho.dsa.tree;

import java.util.Stack;

public class KthSmallestInBST {
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        int count = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode curr = root;
        while (!st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode top = st.pop();
                count++;
                if (count == k) {
                    return top.val;
                }

                curr = top.right;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = { 5, 3, 6, 2, 4, null, null, 1 };
        int k = 3;

        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(kthSmallest(root, k));
    }
}
