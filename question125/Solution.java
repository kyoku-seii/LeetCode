package com.leetcode.question125;

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        int start = 0;
        int end = s.length()-1;
        char start_char ;
        char end_char ;

        while(start<=end){
            start_char = s.charAt(start);
            end_char = s.charAt(end);
            while (!((start_char>=48&&start_char<=57)||(start_char>=65&&start_char<=90))){
                start++;
                if(start>s.length()-1)return true;
                start_char = s.charAt(start);
            }
            while (!((end_char>=48&&end_char<=57)||(end_char>=65&&end_char<=90))){
                end--;
                if(end<0)break;
                end_char = s.charAt(end);
            }
            if(!mojiEquals(start_char,end_char)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean mojiEquals(char a, char b) {
        return a == b;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution solution = new Solution();
        boolean a = solution.isPalindrome(s);
        System.out.println(a);
    }
}
