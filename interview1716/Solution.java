package com.leetcode.interview1716;

public class Solution {
    public int massage(int[] nums) {
        int time [] = new int[nums.length];
        if(nums.length==0||nums==null) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        time[0] = nums[0];
        time[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            time[i] = Math.max(time[i-1],time[i-2]+nums[i]);
        }
        return time[nums.length-1];
    }
}
