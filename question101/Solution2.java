package com.leetcode.question101;

public class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return turning(root.left,root.right);
    }

    private boolean turning(TreeNode left, TreeNode right) {
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        if(left.val!=right.val) return false;

        return turning(left.left,right.right)&&turning(left.right,right.left);
    }
}
