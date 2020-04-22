package com.leetcode.question1021;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String removeOuterParentheses(String S) {
        int s = 0;
        List<String> list = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                stack.add(S.charAt(i));
            }
            else {
                stack.pop();
                if(stack.isEmpty()){
                    list.add(S.substring(s,i+1));
                    s = i+1;
                }
            }
        }
        StringBuilder answer= new StringBuilder();

        for(String temp:list){
                answer.append(temp, 1, temp.length() - 1);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.removeOuterParentheses("(()())(())(()(()))");
        System.out.println(answer);
    }
}
