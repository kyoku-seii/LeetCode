package com.leetcode.question17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> answer = letterCombinations(map, digits, 0);
        return answer;
    }

    private List<String> letterCombinations(Map<Character, char[]> map, String digits, int start) {
        if (start >= digits.length()) {
            return null;
        }
        List<String> backAnswer = letterCombinations(map, digits, start + 1);
        char[] currentWordGroup = map.get(digits.charAt(start));
        LinkedList<String> answer = new LinkedList<>();
        for (char c : currentWordGroup) {
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            if (backAnswer == null) {
                answer.add(sb.toString());
            } else {
                for (String s : backAnswer) {
                    sb.append(s);
                    answer.add(sb.toString());
                }
            }
        }
        return backAnswer;
    }
}
