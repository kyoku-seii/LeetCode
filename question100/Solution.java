package com.leetcode.question100;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p == null)return false;
        if(q == null)return false;
        if(p.val==q.val){
            boolean result_left = isSameTree(p.left,q.left);
            boolean result_right = isSameTree(p.right,q.right);
            return result_left && result_right;
        }
        return false;
    }
}
