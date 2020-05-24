package com.leetcode.question18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(len<4) return ans;
        Arrays.sort(nums);

        for(int i=0;i<len-3;i++){
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)break;
            if(nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target)continue;
            if(i>0&&nums[i]==nums[i-1]) continue;
            int aim = target - nums[i];


            //转变成三数问题
            for(int j=i+1;j<len-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int leftpoint = j+1;
                int rightpoint = len-1;
                while(leftpoint<rightpoint){
                    int sum = nums[j]+ nums[leftpoint]+nums[rightpoint];
                    if(sum==aim){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[leftpoint],nums[rightpoint]));
                        while (leftpoint<rightpoint&&nums[leftpoint]==nums[leftpoint+1])leftpoint++;
                        while (leftpoint<rightpoint&&nums[rightpoint]==nums[rightpoint-1])rightpoint--;
                        leftpoint++;
                        rightpoint--;
                    }else if(sum<aim)leftpoint++;
                    else rightpoint--;
                }
            }
        }
        return ans;
    }
}