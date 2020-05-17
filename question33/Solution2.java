package com.leetcode.question33;

public class Solution2 {


    private int findRotation(int[] nums, int left, int right) {
        if(nums.length<=2)return 0;
        int mid = (int) (left + right) / 2;
        if (nums[mid]>nums[mid+1]) return mid;
        if(nums[mid-1]>nums[mid])return mid-1;
        if(nums[0] < nums[mid]) {
            left = mid+1;
            return findRotation(nums,left,right);
        }else {
            right = mid -1;
            return findRotation(nums,left,right);
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int a = solution2.findRotation(new int[]{6,7, 0, 1, 2, 4, 5},0,6);
        System.out.println(a);

    }
}