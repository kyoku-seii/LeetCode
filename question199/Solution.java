package com.leetcode.question199;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        if(root==null) return answer;

        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        int len = queue.size();

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
            count++;
            if(count==len){
                answer.add(temp.val);
                count=0;
                len = queue.size();
            }
        }
        return answer;
    }
}
