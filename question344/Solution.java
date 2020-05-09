package com.leetcode.question344;

public class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while(i<=j){
            swap(s,i,j);
            i++;
            j--;
        }
    }

    private void swap(char[] s, int i, int j) {
        if(i==j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
