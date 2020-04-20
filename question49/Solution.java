package com.leetcode.question49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null) return new LinkedList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String key = String.valueOf(sArray);
            if(!map.containsKey(key)) map.put(key,new LinkedList<String>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
