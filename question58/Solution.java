package com.leetcode.question58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int i=s.length()-1;
        for(;i>=0;i--){
            if (s.charAt(i)!=' ')break;
        }
        String temp = s.substring(0,i+1);
        String[] res = temp.split(" ");
        return res[res.length-1].length();
    }
}
