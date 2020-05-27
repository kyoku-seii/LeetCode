package com.leetcode.question343;

public class Solution {
    public int integerBreak(int n) {
        int[] memo = new int[n+1];
        return breakInteger(n,memo);
    }

    private int breakInteger(int n,int[] memo) {
        if(n==1) {
            memo[1] = 1;
            return memo[1];
        }

        int res = -1;
        if(memo[n]==0){
            for(int i=1;i<=n-1;i++){
                res = max3(res,i*(n-i),i*(breakInteger(n-i,memo)));
            }
            memo[n] = res;
        }
        return memo[n];
    }

    private int max3(int res, int i, int i1) {
        return Math.max(res,Math.max(i,i1));
    }

}
