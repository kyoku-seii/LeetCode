package com.leetcode.question17;

import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return Collections.emptyList();
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
                    StringBuilder temp = new StringBuilder(sb);
                    temp.append(s);
                    answer.add(temp.toString());
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations(new String("23"));
    }
}
