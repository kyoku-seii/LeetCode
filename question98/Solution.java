package com.leetcode.question98;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;

        if(root.left==null){
            return isValidBST(root.right)&&root.val<getmin(root.right);
        }
        if(root.right==null){
            return isValidBST(root.left)&&root.val>getmax(root.left);
        }
        return isValidBST(root.left)&&isValidBST(root.right)&&(getmax(root.left)<root.val)&&(root.val<getmin(root.right));
    }

    private int getmax(TreeNode left) {
        if(left.right==null){
            return left.val;
        }
        return getmax(left.right);
    }

    private int getmin(TreeNode right) {
        if(right.left==null){
            return right.val;
        }
        return getmin(right.left);
    }
}
