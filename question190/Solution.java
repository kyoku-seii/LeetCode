package com.leetcode.question190;

import java.util.Stack;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String num = Integer.toBinaryString(n);
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<num.length();i++){
            stack.add(num.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return Integer.parseInt(sb.toString());
    }
}