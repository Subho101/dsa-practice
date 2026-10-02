package com.subho.dsa.tree;

import java.util.Stack;

class BSTIterator {

    private boolean isReversed = false;
    private Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root, boolean isReversed) {
        this.isReversed = isReversed;
        pushAll(root);
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode temp = st.pop();
        if (!isReversed)
            pushAll(temp.right);
        else
            pushAll(temp.left);
        return temp.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            if (!isReversed) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }
}

public class TwoSumBST {
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while (l.hasNext() && r.hasNext() && i < j) {
            if (i + j == k)
                return true;
            else if (i + j < k) {
                i = l.next();
            } else {
                j = r.next();
            }
        }

        return false;
    }
}
