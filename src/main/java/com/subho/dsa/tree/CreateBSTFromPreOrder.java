package com.subho.dsa.tree;

public class CreateBSTFromPreOrder {
    public static TreeNode bstFromPreorder(int[] preorder) {
        // return bstFromPreorder(preorder, 0, preorder.length - 1);
        int[] index = { 0 };
        return bstFromPreorder(preorder, Integer.MAX_VALUE, index);
    }

    public static TreeNode bstFromPreorder(int[] preorder,
            int leftStart, int leftEnd) {

        if (leftStart > preorder.length || leftStart > leftEnd)
            return null;

        TreeNode root = new TreeNode(preorder[leftStart]);
        int rootVal = root.val;

        int startLeft = leftStart + 1;
        while (startLeft < preorder.length && preorder[startLeft] < rootVal) {
            startLeft++;
        }

        root.left = bstFromPreorder(preorder, leftStart + 1, startLeft - 1);
        root.right = bstFromPreorder(preorder, startLeft, leftEnd);

        return root;
    }

    public static TreeNode bstFromPreorder(int[] preorder,
            int upperBound, int[] index) {

        // Optimal

        // Return null if either we have run out of index or current value is greater
        // than the current upperbound
        if (index[0] == preorder.length || preorder[index[0]] > upperBound)
            return null;

        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = bstFromPreorder(preorder, root.val, index); // left tree should have value less than root.val, so
                                                                // here upperbound will be root.val
        root.right = bstFromPreorder(preorder, upperBound, index); // right tree can have value greater than root.val
                                                                   // but less than the current upperbound
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 8, 5, 1, 7, 10, 12 };
        TreeNode root = bstFromPreorder(preorder);
        Traversal.preorder(root);
    }
}
