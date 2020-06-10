package com.leetcode.question338;

public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i=0;i<=num;i++){
            int temp = findOne(i);
            res[i] = temp;
        }
        return res;

    }

    private int findOne(int i) {
        int tempSum = 0;
        while (i!=0){
            i = i&(i-1);
            tempSum++;
        }
        return tempSum;
    }
}
