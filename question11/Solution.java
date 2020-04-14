package com.leetcode.question11;

public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int amount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                int temp = Math.abs(i-j)*Math.min(height[i],height[j]);
                if(temp>amount)
                    amount = temp;
            }
        }
        return amount;
    }
}
