package com.leetcode.question211;

import java.util.TreeMap;

public class WordDictionary {
    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private Node root;

    public WordDictionary(){
        root = new Node();

    }

    public void addWord(String word){

        Node cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next.get(c)==null)
                cur.next.put(c,new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }
}
