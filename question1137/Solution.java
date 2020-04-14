package com.leetcode.question1137;
//該方法運行時間過長
public class Solution {
    public int tribonacci(int n) {
        if(n==2){
            return 1;
        }
        if (n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        int answer = tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        return answer;
    }
}