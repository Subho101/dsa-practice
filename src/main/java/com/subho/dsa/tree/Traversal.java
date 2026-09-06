package com.subho.dsa.tree;

public class Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Inorder:");
        inorder(root);
        System.out.println("\nPreorder:");
        preorder(root);
        System.out.println("\nPostorder:");
        preorder(root);
    }

    public static void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + ", ");
            inorder(node.right);
        }
    }

    public static void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + ", ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + ", ");
        }
    }
}
