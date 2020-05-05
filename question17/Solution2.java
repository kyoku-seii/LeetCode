package com.leetcode.question17;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0) return Collections.emptyList();
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> answer = new LinkedList<>();
        letterCombinations(map, digits,"",answer);
        return answer;
    }

    private void letterCombinations(HashMap<Character, char[]> map, String digits,String temp,List<String> answer){

        if(temp.length()==digits.length()){
            answer.add(temp);
            return;
        }

        char key = digits.charAt(temp.length());
        char[] wordGroup = map.get(key);
        for(char c:wordGroup){
            String newtemp = temp + c;
            letterCombinations(map,digits,newtemp,answer);

        }
    }
}
