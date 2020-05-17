package com.leetcode.question367;


public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<2)return true;
        long left = 1;
        long right = num/2;
        long mid = left;
        while(left<=right){
            mid = left + (right-left)/2;
            if(mid*mid==num) return true;
            else if(mid*mid<num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}
