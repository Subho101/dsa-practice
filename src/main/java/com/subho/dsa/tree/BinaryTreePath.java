package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        binaryTreePathsUtil(root, "", ans);
        return ans;
    }

    private static void binaryTreePathsUtil(TreeNode node, String pathSoFar, List<String> ans) {
        if (node.left == null && node.right == null) {
            System.out.println("End " + pathSoFar + node.val);
            ans.add(pathSoFar + node.val);
            return;
        }

        pathSoFar = pathSoFar + node.val + "->";
        if (node.left != null) {
            binaryTreePathsUtil(node.left, pathSoFar, ans);
        }
        if (node.right != null) {
            binaryTreePathsUtil(node.right, pathSoFar, ans);
        }

    }

    public static void main(String[] args) {
        // Integer[] arr = { 1, 2, 3, null, 5 };
        Integer[] arr = { 1 };
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(binaryTreePaths(root));
    }
}
