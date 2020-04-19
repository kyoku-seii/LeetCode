package com.leetcode.question239;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++){
            int max = findMax(nums,i,i+k-1);
            answer[i] = max;
        }
        return answer;
    }

    private int findMax(int[] nums, int i, int i1) {
        int tempMax = nums[i];
        for(int j=i;j<=i1;j++){
            if(nums[j]>tempMax)
                tempMax = nums[j];
        }
        return tempMax;
    }
}
