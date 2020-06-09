package com.leetcode.question191;

public class Solution {
    public int hammingWeight(int n) {
        n = Math.abs(n);
        int count = 0;
        while(n>0){
            int end = n&1;
            if(end==1) count++;
            n = n >> 1;
        }
        return count;
    }
}
