package com.leetcode.question860;

import java.util.HashMap;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills==null) return false;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(5,0);
        hashMap.put(10,0);
        hashMap.put(20,0);
        for (int bill : bills) {
            if (bill == 5) hashMap.put(5, hashMap.get(5) + 1);
            else if (bill == 10) {
                hashMap.put(5, hashMap.get(5) - 1);
                hashMap.put(10, hashMap.get(10) + 1);
            } else {
                if (hashMap.get(10) > 0) {
                    hashMap.put(10, hashMap.get(10) - 1);
                    hashMap.put(5, hashMap.get(5) - 1);
                } else {
                    hashMap.put(5, hashMap.get(5) - 3);
                }
            }
            for(int j:hashMap.values()){
                if (j<0)return false;
            }
        }
        return true;
    }
}
