package com.leetcode.question84;

public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int left_min=i;
            int right_min=i;
            while(left_min>=0){
                if (heights[left_min]<heights[i])break;
                left_min--;
            }
            while(right_min<heights.length){
                if(heights[right_min]<heights[i])break;
                right_min++;
            }
            int length = right_min-left_min-1;
            int height = heights[i];
            int area = length*height;
            if(area>maxArea)maxArea=area;
        }
        return maxArea;
    }
}
