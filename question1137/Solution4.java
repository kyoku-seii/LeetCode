package com.leetcode.question1137;

    class Tri{
        private  int n=38;
        public int[] nums = new int[n];
        //找到對應索引的
        public int helper(int k){
            if(k==0){
                return 0;
            }

            if(nums[k]!=0){
                return nums[k];
            }

            nums[k] = helper(k-1)+helper(k-2)+helper(k-3);
            return nums[k];
        }

        public Tri(){
            nums[1]=1;
            nums[2]=1;
            helper(n-1);
        }
    }

class Solution4 {
    public static Tri t = new Tri();
    public int tribonacci(int n) {
        return t.nums[n];
    }
}



