package com.leetcode.question15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        int n = nums.length;
        int i,j,k;
        for(i=0;i<n-2;i++){
            for (j=i+1;j<n-1;j++){
                for (k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        //判斷該答案是否已經存在於
                        if(!checkList(answer,temp)){
                            answer.add(temp);
                        }
                    }
                }
            }
        }
        return answer;
    }

    private boolean checkList(List<List<Integer>> answer, List<Integer> temp) {
        if (answer==null){
            return false;
        }
        for(List<Integer> list:answer){
            if (check(list,temp)){
                return true;
            }
        }
        return false;
    }

    private boolean check(List<Integer> list, List<Integer> temp) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:list){
            if(map.containsKey(i)){
                int count = map.get(i);
                map.put(i,count+1);
            }else {
                map.put(i,1);
            }
        }

        for(int j:temp){
            if(!map.containsKey(j)){
                return false;
            }else {
                int count = map.get(j);
                if(count<1){
                    return false;
                }else {
                    map.put(j,count-1);
                }
            }
        }
        return true;
    }
}
