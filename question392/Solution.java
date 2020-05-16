package com.leetcode.question392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s==null||t==null) return false;
        int j=0;
        int i=0;
        while(j<t.length()&&i<s.length()){
            if(t.charAt(j)==s.charAt(i)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
