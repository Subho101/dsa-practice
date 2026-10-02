package com.subho.dsa.tree;

class NodeValue {
    public int maxNode, minNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}

public class LargestBST {

    private NodeValue largestBstHelper(TreeNode root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);

        if (left.maxNode < root.val && root.val < right.minNode) {
            return new NodeValue(
                    Math.min(root.val, left.minNode), // Taking math.min here, because it can be a leaf node, and
                                                      // returning Int max from the null
                    Math.max(root.val, right.maxNode), // Taking math.max here, because it can be a leaf node, and
                                                       // returning Int min from the null
                    left.maxSize + right.maxSize + 1);
        }

        // We are setting very low minvalue and very high max value, as we do not want
        // to further connect the bsts with this node onward
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));

    }

    public int largestBst(TreeNode root) {
        // code here
        return largestBstHelper(root).maxSize;
    }
}
