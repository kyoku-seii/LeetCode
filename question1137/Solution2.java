package com.leetcode.question1137;

public class Solution2 {
    public static class Tri{
        public static int[] nums = new int[38];
        public static void helper(int n){
            nums[0] = 0;
            nums[1] = 1;
            nums[2] = 1;
            for(int i=3;i<=n;i++){
                nums[i] = nums[i-1]+nums[i-2]+nums[i-3];
            }
        }

        Tri(int n){
            Tri.helper(n);
        }

    }
    public int tribonacci(int n) {
        Tri tri = new Tri(37);
        int result = Tri.nums[n];
        return result;
    }
}
