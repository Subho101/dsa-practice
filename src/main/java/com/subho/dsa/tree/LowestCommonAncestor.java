package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        rootToNodePath(root, p, path1);
        rootToNodePath(root, q, path2);

        int n = Math.min(path1.size(), path2.size());
        int i = 0;
        while (i < n) {
            if (path1.get(i) != path2.get(i))
                break;
            i++;
        }

        return i == 0 ? null : path1.get(i - 1);
    }

    public static TreeNode lowestCommonAncestorOptimal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            // If null, return it
            // if either p or q, return it, no need to go further
            return root;
        }

        // Traverse left and right
        TreeNode left = lowestCommonAncestorOptimal(root.left, p, q);
        TreeNode right = lowestCommonAncestorOptimal(root.right, p, q);

        if (left == null) {
            // did not got anything from the left, so return right (even if null)
            return right;
        } else if (right == null) {
            return left;
        } else {
            // both left and right is not null at this point, so at least it is under this
            // node,
            // so return the current node
            return root;
        }
    }

    private static boolean rootToNodePath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null)
            return false;
        path.add(root);

        if (root.val == p.val) {
            return true;
        }

        if (rootToNodePath(root.left, p, path) || rootToNodePath(root.right, p, path))
            return true;

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {

    }
}
