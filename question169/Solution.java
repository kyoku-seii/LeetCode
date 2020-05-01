package com.leetcode.question169;

import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxNumber=nums[0];
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num)>map.get(maxNumber))
                maxNumber = num;
        }
        return maxNumber;
    }
}
