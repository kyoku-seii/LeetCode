package com.leetcode.question146;

public class DoubleLinkedList {
    int capacity,size;
    Node head,tail;
    public DoubleLinkedList(int capacity){
        this.capacity = capacity;
        this.size = 0;
        head = null;
        tail = null;
    }

    private Node addHead(Node node){
        if(head==null){
            head = node;
            tail = node;
            head.next = null;
            head.prev = null;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = null;
        }
        size++;
        return node;
    }

    private Node addTail(Node node){
        if(tail==null){
            tail = node;
            head = node;
            tail.next = null;
            tail.prev = null;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
        }
        size++;
        return node;
    }

    private Node delTail(){
        if(tail==null) return null;
        Node node = tail;
        if (node.prev!=null){
            tail = node.prev;
            tail.next = null;
        }else {
            tail = null;
            head = null;
        }
        size--;
        return node;
    }

    private Node delHead(){
        if (head==null)return null;
        Node node = head;
        if(node.next!=null){
            head = node.next;
            head.prev = null;
        }else {
            head=null;
            tail=null;
        }
        size--;
        return node;
    }

    private Node remove(Node node){
        if(node==null)
            node = tail;

        if(node==tail){
            node = delTail();
        }else if(node==head){
            node = delHead();
        }else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        return node;
    }

    public Node pop(){
        return delHead();
    }

    public Node append(Node node){
        return addTail(node);
    }

    public Node appendFront(Node node){
        return addHead(node);
    }

    public Node removeNode(Node node){
        return remove(node);
    }

    @Override
    public String toString(){
        Node p = head;
        StringBuilder sb = new StringBuilder();
        while (p!=null){
            sb.append(p.toString());
            p = p.next;
            if (p!=null) sb.append("->");
        }
        return sb.toString();
    }
}
