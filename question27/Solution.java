package com.leetcode.question27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // [0,i)之间是非目标元素的值
        for(int j=0; j<nums.length;j++){
            if(nums[j]!=val){
                swap(nums,j,i);
                i++;
            }
        }
        return i;
    }

    private void swap(int[] nums, int j, int i) {
        if (i==j) return;
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
