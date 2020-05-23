package com.leetcode.question451;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public String frequencySort(String s) {
        if(s==null||s.length()==0)return null;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!hashMap.containsKey(s.charAt(i))) hashMap.put(s.charAt(i), 1);
            else hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return hashMap.get(o2)-hashMap.get(o1);
            }
        });

        pq.addAll(hashMap.keySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char temp = pq.poll();
            int repeat = hashMap.get(temp);
            for(int j=0;j<repeat;j++){
                sb.append(temp);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("aaaadwadwa"));
    }
}
