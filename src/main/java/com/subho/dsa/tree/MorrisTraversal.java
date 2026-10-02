package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    // ans.add(curr.val); // for inorder add here
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}
