package com.leetcode.question208;

import java.util.HashMap;

public class Trie {
    private class Node{
        boolean isWord;
        HashMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

        public Node(){
            this(false);
        }
    }
    private Node root;
    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node cur = root;
        for(int i=0;i<word.length();i++){
            Character tempC = word.charAt(i);
            if(!cur.next.containsKey(tempC)){
                cur.next.put(tempC,new Node());
            }
            cur = cur.next.get(tempC);
        }
        cur.isWord = true;
    }

    public boolean search(String word){
        Node cur = root;
        for(int i=0;i<word.length();i++){
            Character tempC = word.charAt(i);
            if(!cur.next.containsKey(tempC)){
                return false;
            }
            cur = cur.next.get(tempC);
        }
        return cur.isWord;
    }

    public boolean startsWith(String word){
        Node cur = root;
        for(int i=0;i<word.length();i++){
            Character tempC = word.charAt(i);
            if(!cur.next.containsKey(tempC)){
                return false;
            }
            cur = cur.next.get(tempC);
        }
        return true;
    }
}
