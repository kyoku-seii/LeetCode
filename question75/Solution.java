package com.leetcode.question75;

public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length<2)return;
        int zero = 0; //[0...zero)表示0
        int two = nums.length-1; // (two...nums.length-1] 表示2
        int cur = 0; //[zero...cur)表示1

        while(cur <= two){
            if(cur<=two&&nums[cur]==2){
                swap(cur,two,nums);
                two--;
            }
            if(cur<=two&&nums[cur]==1){
                cur++;
            }
            if(cur<=two&&nums[cur]==0){
                swap(zero,cur,nums);
                zero++;
                cur++;
            }
        }

    }

    private void swap(int cur, int p2, int[] nums) {
        int  temp = nums[cur];
        nums[cur] = nums[p2];
        nums[p2] = temp;
    }
}
