package com.leetcode.question343;

public class Solution2 {
    public int integerBreak(int n) {
        int[] memo = new int[n+1];
        memo[1] = 1;
        for(int i=2;i<=n;i++){
            //求memo[i]
            for(int j=1;j<=i-1;j++){
                memo[i] = max3(memo[i],j*(i-j),j*memo[i-j]);
            }
        }
        return memo[n];
    }

    private int max3(int res, int i, int i1) {
        return Math.max(res,Math.max(i,i1));
    }
}
