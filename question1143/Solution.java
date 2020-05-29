package com.leetcode.question1143;

import java.util.LinkedList;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        LinkedList<String> text1Substring = new LinkedList<>();
        createSubstring(text1Substring, text1, 0, new StringBuilder());
        int res = 0;
        for (String i : text1Substring) {
            if(includeIntext2(i,text2))
                res = Math.max(res,i.length());

        }
        return res;
    }

    private boolean includeIntext2(String i, String text2) {
        if(i.length()==0) return false;
        int j=0;
        int k=0;
        while(k<text2.length()){
            if(text2.charAt(k)==i.charAt(j)){
                j++;
                if(j==i.length()) return true;
            }
            k++;
        }
        return false;
    }

    private void createSubstring(LinkedList<String> text1Substring, String text1, int i, StringBuilder sb) {
        if (i >= text1.length()) {
            text1Substring.add(sb.toString());
            return;
        }
        char c = text1.charAt(i);
        sb.append(c);
        createSubstring(text1Substring, text1, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        createSubstring(text1Substring, text1, i + 1, sb);
    }
}
