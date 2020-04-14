package com.leetcode.question11;

public class Solution2 {
    public int maxArea(int[] height) {
        int i= 0;
        int j= height.length-1;
        int amount = 0;

        while(i<j){
            int temp = (j-i)*Math.min(height[i],height[j]);
            if(temp>amount){
                amount = temp;
            }
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return amount;
    }
}
