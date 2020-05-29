package com.leetcode.question1143;

public class Solution2 {
    //比较两个字符串，找到他们的最长公共子串
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] table = new int[text1.length()][text2.length()];
        int initx = 0;
        for (int j = 0; j < text2.length(); j++) {
            if (text2.charAt(j) == text1.charAt(0)) initx = 1;
            table[0][j] = initx;
        }

        int inity = 0;
        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(0)) inity = 1;
            table[i][0] = inity;
        }
        if(text1.length()==1||text2.length()==1) return table[text1.length() - 1][text2.length() - 1];

        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) != text2.charAt(j)) {
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                } else {
                    table[i][j] = table[i - 1][j - 1] + 1;
                }
            }
        }
        return table[text1.length() - 1][text2.length() - 1];
    }
}
