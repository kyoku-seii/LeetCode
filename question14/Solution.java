package com.leetcode.question14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)return "";
        if(strs.length==1)return strs[0];
        String first =  strs[0];
        for(int i=0;i<first.length();i++){
            char temp = first.charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i+1>strs[j].length()||strs[j].charAt(i)!=temp) return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}