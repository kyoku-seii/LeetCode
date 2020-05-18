package com.leetcode.question33;


public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int point = findTarget(nums, target);
        if (point == -1) return new int[]{-1, -1};
        int lo = point, ro = point;
        while (lo > 0 && nums[lo] == target) {
            lo--;
            if (nums[lo] != target){
                lo = lo+1;
                break;
            }
        }
        while (ro < nums.length - 1 && nums[ro] == target) {
            ro++;
            if (nums[ro] != target){
                ro = ro -1;
                break;
            }
        }
        return new int[]{lo,ro};
    }

    private int findTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = solution.searchRange(new int[]{0,0,1,2,2},2);
        for(int j:a){
            System.out.println(j);
        }

    }

}

