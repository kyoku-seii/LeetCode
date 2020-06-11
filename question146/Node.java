package com.leetcode.question146;

public class Node {
    int key,value;
    Node prev,next;
    public Node(int key ,int value){
        this.key = key;
        this.value= value;
        prev = null;
        next = null;
    }

    @Override
    public String toString() {
        return "{ " + key + " : " + value + " }";
    }
}
