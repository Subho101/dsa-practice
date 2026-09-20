package com.subho.dsa.tree;

import java.util.ArrayList;

public class InOrderPredeccesorSuccessot {
    public ArrayList<TreeNode> findPreSuc(TreeNode root, int key) {
        // code here
        ArrayList<TreeNode> ans = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre = null, succ = null;

        // Finding Predeccesor
        while (curr != null) {
            if (curr.val < key) { // curr val is smaller than key, potential ans. Store it and search for bigger
                                  // value
                pre = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        curr = root;
        while (curr != null) {
            if (curr.val > key) { // curr val is greater than key, potential ans. Store it and search for smaller
                                  // value
                succ = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        ans.add(pre);
        ans.add(succ);

        return ans;
    }
}
