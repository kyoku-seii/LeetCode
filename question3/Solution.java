package com.leetcode.question3;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int r = -1;
        int l = 0; // [l...r]
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(l<s.length()){
            if(r+1<s.length()&& noDuplicate(map)){
                r++;
                if(!map.containsKey(s.charAt(r))) map.put(s.charAt(r),1);
                else map.put(s.charAt(r),map.get(s.charAt(r))+1);
            }else {
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            if(noDuplicate(map)) res = Math.max(res,(r-l+1));
        }
        return res;
    }

    private boolean noDuplicate(HashMap<Character, Integer> map) {
        for(int i:map.values()){
            if(i>=2) return false;
        }
        return true;
    }
}
