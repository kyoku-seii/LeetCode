package com.leetcode.question336;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution3 {
   public class Node{
       int word_index; // 表示到当前字母未止，这个完整的单词所在的索引位置
       List<Integer> suffix;// 表示到当前字母为止（包含这个字母),余下的部分为回文的单词所在的索引
       TreeMap<Character,Node> next;

       public Node(){
           word_index = -1;
           suffix = new ArrayList<>();
           next = new TreeMap<>();
       }
   }

   private Node root;//树的根

    public List<List<Integer>> palindromePairs(String[] words) {
        //将所有的单词反转之后保存到树中
        root = new Node();
        for(int i=0;i<words.length;i++){
            String rev = new StringBuilder(words[i]).reverse().toString();
            Node cur = root; // 当前所在的cur指针
            if(isPalindrome(rev)) cur.suffix.add(i); //如果单词本身就是一个回文则在根处表明
            for(int j=0;j<rev.length();j++){
                if (cur.next.get(rev.charAt(j))==null)
                    cur.next.put(rev.charAt(j),new Node());
                cur = cur.next.get(rev.charAt(j));
                if(isPalindrome(rev.substring(j+1)))cur.suffix.add(i);
            }
            cur.word_index = i;
        }

        //答案
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<words.length;i++){
            String word = words[i];
            Node cur = root;
            int j = 0;
            for(;j<word.length();j++){
                if(isPalindrome(word.substring(j))){
                    if(i!=cur.word_index&&cur.word_index!=-1){
                        ans.add(Arrays.asList(i,cur.word_index));
                    }
                }

                if (cur.next.get(word.charAt(j))==null)
                    break;
                cur = cur.next.get(word.charAt(j));
            }

            //正常的遍历完成
            if(j == word.length()){
                for(int q:cur.suffix){
                    if (q != i) ans.add(Arrays.asList(i,q));
                }
            }
        }
        return ans;

    }

    //判断是否是回文
    private boolean isPalindrome(String w) {
        int i = 0, j = w.length()-1;
        while (i < j) {
            if (w.charAt(i) != w.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
