package com.leetcode.question150;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens==null) return -1;
        Stack<String> stack = new Stack<>();
        HashSet<String> operators = new HashSet<>();
        operators.add(String.valueOf('+'));
        operators.add(String.valueOf('-'));
        operators.add(String.valueOf('*'));
        operators.add(String.valueOf('/'));

        for (String temp : tokens) {
            if (!operators.contains(temp)) stack.add(temp);
            else {
                if (temp.equals(String.valueOf('+'))) {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(a + b));
                }
                if (temp.equals(String.valueOf('-'))) {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(a - b));
                }
                if (temp.equals(String.valueOf('*'))) {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(a * b));
                }
                if (temp.equals(String.valueOf('/'))) {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(a / b));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
