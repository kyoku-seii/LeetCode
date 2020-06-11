package com.leetcode.question146;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    HashMap<Integer,Node> map;
    DoubleLinkedList dl;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        dl = new DoubleLinkedList(capacity);
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            dl.removeNode(node);
            dl.appendFront(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            dl.removeNode(node);
            node.value = value;
            dl.appendFront(node);
        }else {
            Node node = new Node(key,value);
            if (dl.size>=capacity){
                Node temp = dl.removeNode(null);
                map.remove(temp.key);
            }
            dl.appendFront(node);
            map.put(key,node);
            }
        }
}
