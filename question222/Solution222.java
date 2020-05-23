package com.leetcode.question222;

public class Solution222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }
}
