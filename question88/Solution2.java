package com.leetcode.question88;

import java.util.Arrays;

public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[]temp = Arrays.copyOfRange(nums1,0,m);
        int i=0;//temp的索引
        int j=0;//nums2的索引
        for(int x=0;x<=m+n-1;x++){
            if(i>=m){
                nums1[x] = nums2[j];
                j++;
            }else if (j>=n){
                nums1[x] = temp[i];
                i++;
            }else if(temp[i]<nums2[j]){
                nums1[x] = temp[i];
                i++;
            }else {
                nums1[x] = nums2[j];
                j++;
            }
        }
    }
}
