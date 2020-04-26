package com.leetcode.question75;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null) return;
        if (nums.length<3) return;
        int p1 = 0;
        int p2 = nums.length-1;
        int cur = 0;
        while(cur <= p2){
            if (nums[cur] == 2){
                swap(cur,p2,nums);
                p2--;
            }
            if(cur <= p2&&nums[cur]==1){
                cur++;
            }
            if(cur <= p2&&nums[cur]==0){
                swap(cur,p1,nums);
                cur++;
                p1++;
            }
        }

    }

    private void swap(int cur, int p2, int[] nums) {
        int  temp = nums[cur];
        nums[cur] = nums[p2];
        nums[p2] = temp;
    }
}
