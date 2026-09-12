package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class SerializeDeserlize {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return "";
        List<String> nodes = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                nodes.add("#");
                continue;
            }
            nodes.add(String.valueOf(curr.val));
            q.add(curr.left);
            q.offer(curr.right);
        }

        return nodes.stream().collect(Collectors.joining(","));

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.charAt(0) == '#')
            return null;

        String[] nodeVals = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (i < nodeVals.length && !q.isEmpty()) {
            TreeNode curr = q.poll();
            if (i < nodeVals.length && !nodeVals[i].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(nodeVals[i]));
                q.offer(curr.left);
            }
            i++;

            if (i < nodeVals.length && !nodeVals[i].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(nodeVals[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, null, null, 4, 5 };
        TreeNode root = TreeNode.buildTree(arr);

        String serialized = serialize(root);
        System.out.println(serialized);
        TreeNode deSerialized = deserialize(serialized);
        Traversal.inorder(deSerialized);
    }
}
