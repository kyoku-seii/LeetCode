package com.leetcode.question336;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<List<Integer>> palindromePairs(String[] words) {
        ArrayList<List<Integer>> answer = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                //对于所有可能的组合进行遍历
                if(j==i)
                    continue;
                String string = words[i].concat(words[j]);
//                System.out.println(string);
                //进行回文的判断
                if(judgePalindrome(string)){
                    //如果是回文的话则保留当前的i与j
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    answer.add(list);
                }
                //如果不是回文则什么都不做
            }
        }
        return answer;
    }

    private boolean judgePalindrome(String string){
        int l = 0;
        int r = string.length()-1;
        int mid = (l+r)/2;
        while(l<=mid){
            if(string.charAt(l)!=string.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] string = new String[]{"abcd","dcba","lls","s","sssll"};
        System.out.println(solution.palindromePairs(string));
    }
}

