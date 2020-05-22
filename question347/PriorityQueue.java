package com.leetcode.question347;

import java.util.Comparator;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private Maxheap<E> maxheap;
    public PriorityQueue(){
        maxheap = new Maxheap<>();
    }

    public PriorityQueue(Comparator<Integer> integerComparator) {
    }

    @Override
    public int getSize(){
        return maxheap.size();
    }

    @Override
    public boolean isEmpty(){
        return maxheap.isEmpty();
    }

    @Override
    public E getFront(){
        return maxheap.findMax();
    }
    @Override
    public void enqueue(E e){
        maxheap.add(e);
    }
    @Override
    public E dequeue(){
        return maxheap.extractMax();
    }

}
