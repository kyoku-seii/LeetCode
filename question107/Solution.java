package com.leetcode.question107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
          List<List<Integer>> answer = new LinkedList<>();
          if(root==null) return answer;

          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);
          int len = queue.size();
          int count = 0;
          List<Integer> layer = new LinkedList<>();

          while(!queue.isEmpty()){
              TreeNode temp = queue.remove();
              layer.add(temp.val);
              if(temp.left!=null) queue.add(temp.left);
              if(temp.right!=null) queue.add(temp.right);
              count++;
              if(count==len){
                  len= queue.size();
                  count = 0;
                  answer.add(0,layer);
                  layer = new LinkedList<>();
              }
          }
          return answer;
    }
}
