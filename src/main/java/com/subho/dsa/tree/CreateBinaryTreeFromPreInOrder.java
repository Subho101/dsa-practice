package com.subho.dsa.tree;

import java.util.HashMap;
import java.util.Map;

public class CreateBinaryTreeFromPreInOrder {

    public static TreeNode buildTreeFrom(int[] preorder, int[] inorder) {
        Map<Integer, Integer> iMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            iMap.put(inorder[i], i);
        }

        TreeNode root = buildTreeFrom(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, iMap);

        return root;
    }

    private static TreeNode buildTreeFrom(int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd, Map<Integer, Integer> iMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = iMap.get(preorder[preStart]);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeFrom(preorder, preStart + 1, preStart + numsLeft,
                inorder, inStart, inRoot - 1, iMap);

        root.right = buildTreeFrom(preorder, preStart + numsLeft + 1, preEnd,
                inorder, inRoot + 1, inEnd, iMap);

        return root;

    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 }, inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = buildTreeFrom(preorder, inorder);
        System.out.println(root);
        Traversal.inorder(root);
    }
}
