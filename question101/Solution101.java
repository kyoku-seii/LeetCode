package com.leetcode.question101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution101 {
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
        List<Integer> leftList = leftTraversal(root.left);
        List<Integer> rightList = righrTraversal(root.right);
        if(leftList.size()!= rightList.size())return false;
        for(int i=0;i<leftList.size();i++){
            if(leftList.get(i)!=rightList.get(i))
                return false;
        }
        return true;
    }

    private List<Integer> righrTraversal(TreeNode right) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(right);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp==null){
                list.add(null);
            }else {
                list.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return list;
    }

    private List<Integer> leftTraversal(TreeNode left) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(left);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp==null){
                list.add(null);
            }else {
                list.add(temp.val);
                queue.add(temp.right);
                queue.add(temp.left);
            }
        }
        return list;
    }

}
