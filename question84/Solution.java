package com.leetcode.question84;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights==null)return -1;
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int minValue =heights[i];
            for(int j=i;j<heights.length;j++){
                if(heights[j]<minValue)minValue=heights[j];
                int height = minValue;
                int width = j-i+1;
                int temp = height*width;
                if(temp>maxArea)maxArea= temp;
            }
        }
        return maxArea;
    }
}
