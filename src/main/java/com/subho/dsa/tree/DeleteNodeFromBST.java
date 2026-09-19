package com.subho.dsa.tree;

public class DeleteNodeFromBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            return helper(root);
        }

        TreeNode curr = root;
        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }

        return root;
    }

    private static TreeNode helper(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        if (node.right == null) {
            return node.left;
        }

        TreeNode rightChild = node.right;
        TreeNode rightMostNodeLeftChild = findLast(node.left);
        rightMostNodeLeftChild.right = rightChild;

        return node.left;
    }

    private static TreeNode findLast(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return findLast(node.right);
    }

    public static void main(String[] args) {

    }
}
