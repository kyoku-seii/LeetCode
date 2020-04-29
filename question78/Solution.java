package com.leetcode.question78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        return process(0,nums);
    }

    private List<List<Integer>> process(int start , int[]nums){
        if(start>=nums.length){
            ArrayList<List<Integer>> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            a.add(b);
            return a;
        }


        List<List<Integer>> backResult = process(start+1,nums);
        LinkedList<List<Integer>> temp = new LinkedList<>(backResult);
        for(List<Integer> j:backResult){
            ArrayList<Integer> tempList = new ArrayList<>(j);
            tempList.add(nums[start]);
            temp.add(tempList);
        }

        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List a = solution.subsets(new int[]{1,2,3});
        System.out.println(a);
    }
}
