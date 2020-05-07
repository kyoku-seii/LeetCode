package com.leetcode.question283;

public class Solution3 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                swap(nums,j,i);
                i++;
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        if(i==j) return ;
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] = temp;
    }
}
