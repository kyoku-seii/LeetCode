package com.leetcode.question46;

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        return permutation(set);
    }

    private List<List<Integer>> permutation(HashSet<Integer> set){
        List<List<Integer>> answer = new LinkedList<>();

        if (set.isEmpty()){
            answer.add(new LinkedList<>());
            return answer;
        }

        for(Integer i:set){
            HashSet<Integer> temp = new HashSet<>(set);
            temp.remove(i);
            List<List<Integer>> backAnswer = permutation(temp);

            for (List<Integer> backPermute:backAnswer){
                backPermute.add(0,i);
                answer.add(backPermute);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permute(new int[]{1,2,3});
    }
}
