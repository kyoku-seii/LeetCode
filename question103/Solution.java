package com.leetcode.question103;

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

      public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
          List<List<Integer>> answer = new LinkedList<>();
          if(root==null) return answer;
          Queue<TreeNode> queue = new LinkedList<>();

          int count = 0;
          queue.add(root);
          int len = queue.size();
          int layerNum = 1;
          List<Integer> layer = new LinkedList<>();

          while(!queue.isEmpty()){
                TreeNode temp = queue.remove();
                if(layerNum%2==1)
                      layer.add(temp.val);
                else layer.add(0,temp.val);
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
                count++;
                if(count==len){
                      layerNum++;
                      count=0;
                      len = queue.size();
                      answer.add(layer);
                      layer = new LinkedList<>();
                }
          }
          return answer;
      }
}
