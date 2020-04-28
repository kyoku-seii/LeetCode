package com.leetcode.question226;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode answer = new TreeNode(root.val);
        answer.left = invertTree(root.right);
        answer.right = invertTree(root.left);
        return answer;
    }
}
