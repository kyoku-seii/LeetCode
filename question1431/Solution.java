package com.leetcode.question1431;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = -1;
        for(int i:candies){
            maxCandies = Math.max(maxCandies,i);
        }

        LinkedList<Boolean> ans = new LinkedList<>();
        for (int candy : candies) {
            ans.add(candy + extraCandies >= maxCandies);
        }
        return ans;
    }
}
