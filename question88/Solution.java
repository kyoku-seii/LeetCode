package com.leetcode.question88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int i=0; // nums1的索引
        int j=0; // nums2的索引
        int k=0; // copy的索引
        while(j<n&&k<m){  // 目前还没有一个数组被取光
            if(j<n&&k<m && nums1_copy[k]>nums2[j]){
                nums1[i] = nums2[j];
                i++;
                j++;
            }
            if(j<n&&k<m&& nums1_copy[k]<=nums2[j]){
                nums1[i] = nums1_copy[k];
                k++;
                i++;
            }
        }

        if(j==n){
            for(;i<m+n;i++){
                nums1[i] = nums1_copy[k];
                k++;
            }
        }
        if(k==m){
            for(;i<m+n;i++){
                nums1[i] = nums2[j];
                j++;
            }
        }
    }
}
