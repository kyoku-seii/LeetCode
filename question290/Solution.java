package com.leetcode.question290;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        char[] patternChar = pattern.toCharArray();

        if(word.length!=patternChar.length)return false;

        HashMap<Character,String> pair = new HashMap<>();
        HashSet<String> used = new HashSet<>();

        for(int i=0;i<pattern.length();i++){
            if(!pair.containsKey(patternChar[i]))
                if(!used.contains(word[i])){
                    pair.put(patternChar[i],word[i]);
                    used.add(word[i]);
                }else {
                    return false;
                }
            else {
                if(!pair.get(patternChar[i]).equals(word[i]))
                    return false;
            }
        }
        return true;
    }
}
