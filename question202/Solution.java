package com.leetcode.question202;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> result = new HashSet<>();
        while(!result.contains(n)){
            if(n==1) return true;
            result.add(n);

            String strN = String.valueOf(n);

            int sum = 0;
            for (int i=0;i<strN.length();i++){
                sum += Integer.parseInt(String.valueOf(strN.charAt(i)))*Integer.parseInt(String.valueOf(strN.charAt(i)));
            }
            n = sum;
        }
        return false;
    }
}
