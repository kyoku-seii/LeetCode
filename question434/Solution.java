package com.leetcode.question434;

public class Solution {
    public int countSegments(String s) {
        String[] sub = s.split(" ");
        int res = 0;
        for(String s1:sub){
            if(s1.length()!=0) res++;
        }
        return res;
    }
}
