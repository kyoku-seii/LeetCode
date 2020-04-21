package com.leetcode.question40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] answer = new int[k];
        if(k==0) return answer;
        for(int i=0;i<arr.length;i++){
            if(i<k) answer[i] = arr[i];
            else {
                Arrays.sort(answer);
                if(arr[i]<answer[k-1])
                    answer[k-1] = arr[i];
            }
        }
        return answer;
    }
}
