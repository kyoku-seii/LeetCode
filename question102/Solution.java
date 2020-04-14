package com.leetcode.question102;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int len;//记录当前层次中节点的个数
        int count=0;
        if(root==null){
            answer.add(new ArrayList<>());
        }
        queue.add(root);
        len=queue.size();
        List<Integer> layer = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            layer.add(temp.val);
            count++;
            if(count==len){
                count = 0;
                answer.add(layer);
                layer = new ArrayList<>();
                len = queue.size();
            }
        }
        return answer;
    }
}
