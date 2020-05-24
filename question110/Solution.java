package com.leetcode.question110;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null) return  true;

        boolean leftIsBalanced = isBalanced(root.left);
        boolean rightISBalanced = isBalanced(root.right);

        if(!leftIsBalanced||!rightISBalanced) return false;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight-rightHeight)<=1;

    }

    private int height(TreeNode root) {
        if(root==null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh)+1;
    }
}
