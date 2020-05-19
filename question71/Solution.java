package com.leetcode.question71;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        if(path==null)return null;
        Stack<String> stack = new Stack<>();
        String[] pathSplited = path.split("/");
        for(String temp:pathSplited){
            if (temp.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else {
                if(!temp.equals("")&&!temp.equals(".")){
                    stack.add(temp);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        String answer = sb.toString();
        if (answer.equals(""))return "/";
        else return sb.toString();
    }
}
