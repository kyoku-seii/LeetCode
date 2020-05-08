package com.leetcode.question80;


public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1)return 1;
        int i = 0;
        int count = 1;
        for(int j=1; j<nums.length; j++){
            if(nums[j]==nums[i]&& count<2){
                i++;
                swap(nums,i,j);
                count++;
            }else {
                if(nums[j]!=nums[i]){
                    i++;
                    swap(nums,i,j);
                    count = 1;
                }
            }
        }
        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        if(i==j)return;
        int temp = nums[i];
        nums[i] = nums [j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeDuplicates(new int[]{1,1,1,2,2,3});
    }
}
