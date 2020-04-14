package com.leetcode.question1160;

import java.util.HashMap;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<chars.length();i++){
            if(map.containsKey(chars.charAt(i))){
                int curNum = map.get(chars.charAt(i));
                map.put(chars.charAt(i),curNum+1);
            }else {
                map.put(chars.charAt(i), 1);
            }
        }

        int output = 0;
        for(String word :words){
            int j =0;
            HashMap<Character, Integer> temp = new HashMap<>(map);
            for(;j<word.length();j++){
                //如果字典中都沒有相對應的單詞則自然沒有
                if(!temp.containsKey(word.charAt(j))){
                    break;
                }
                //字的數量不夠了
                if(temp.get(word.charAt(j))<1){
                    break;
                }
                int amount = temp.get(word.charAt((j)))-1;
                temp.put(word.charAt(j),amount);
            }
            if(j==word.length()){
                output = output + word.length();
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.countCharacters(
                new String[]{"hello","world","leetcode"},
        "welldonehoneyr");
        System.out.println(result);
    }
}
