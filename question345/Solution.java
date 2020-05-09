package com.leetcode.question345;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public String reverseVowels(String s) {
        if(s==null) return null;

        char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        HashSet<Character> set = new HashSet<>();
        for(char c:vowel){
            set.add(c);
        }

        char[] string = s.toCharArray();

        int i = 0;
        int j = string.length-1;
        while(i<j){
            while(!set.contains(string[i])&&i<j){
                i++;
            }
            while(!set.contains(string[j])&&i<j){
                j--;
            }
            swap(string,i,j);
            i++;
            j--;
        }

        return new String(string);
    }

    private void swap(char[] string, int i, int j) {
        if(i==j) return;
        char temp = string[i];
        string[i] = string[j];
        string[j] = temp;
    }
}
