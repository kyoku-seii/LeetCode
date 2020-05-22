package com.leetcode.question23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val-o2.val);
            }
        });

        for(int i=0;i<lists.length;i++){
            if(lists[i]==null) continue;
            while(lists[i]!=null){
                pq.add(lists[i]);
                lists[i]= lists[i].next;
            }
        }

        ListNode dummyhead = new ListNode(-1);
        ListNode head = dummyhead;
        while(!pq.isEmpty()){
            dummyhead.next = pq.remove();
            dummyhead = dummyhead.next;
        }
        dummyhead.next = null;
        return head.next;
    }
}
