package com.subho.dsa.tree;

import java.util.Stack;

public class IterativeTraversal {
    public static void preorder(TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        st.push(node);

        while (!st.isEmpty()) {
            TreeNode currNode = st.pop();
            System.out.println(currNode.val);

            if (currNode.right != null)
                st.push(currNode.right);
            if (currNode.left != null)
                st.push(currNode.left);
        }
    }

    public static void inorder(TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> st = new Stack<>();

        TreeNode currNode = node;

        while (true) {
            if (currNode != null) {
                st.push(currNode);
                currNode = currNode.left;
            } else {
                if (st.isEmpty())
                    break;
                TreeNode top = st.pop();
                System.out.println(top.val);
                currNode = top.right;
            }
        }
    }

    public static void postorder(TreeNode node) {
        if (node == null)
            return;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(node);

        while (!st1.isEmpty()) {
            node = st1.pop();
            st2.push(node);
            if (node.left != null)
                st1.push(node.left);
            if (node.right != null)
                st1.push(node.right);
        }

        while (!st2.isEmpty()) {
            System.out.println(st2.peek().val);
            st2.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // preorder(root);
        // inorder(root);
        postorder(root);
    }
}
