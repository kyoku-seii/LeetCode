package com.leetcode.question131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        return partitionHelper(s,0);
    }

    private List<List<String>> partitionHelper(String s,int start){
        if(start==s.length()){
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s.substring(start, i+1))){
                String left = s.substring(start, i+1);
                for(List<String> l:partitionHelper(s,i+1)){
                    l.add(0,left);
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
