package com.leetcode.question15;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = nums.length;
        if(n < 3||nums==null){
            return answer;
        }
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(nums[i]>0) break;
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int j =i+1;
            int k =n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    answer.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k&&nums[j+1]==nums[j]) j++;
                    while(j<k&&nums[k-1]==nums[k]) k--;
                    j++;
                    k--;
                }else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else {
                    k--;
                }

            }
        }
        return answer;
    }
}
