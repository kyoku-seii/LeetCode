package com.leetcode.question52;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int totalNQueens(int n) {
        if (n < 1) return 0;
        List<Stack<Integer>> answer = new ArrayList<>();

        boolean[] col = new boolean[n];
        boolean[] slash1 = new boolean[2 * n - 1];
        boolean[] slash2 = new boolean[2 * n - 1];
        Stack<Integer> queenPosition = new Stack<>();

        putQueen(n, 0, col, slash1, slash2, queenPosition,answer);
        System.out.println(answer);
        return answer.size();
    }

    private void putQueen(int n, int y, boolean[] col, boolean[] slash1, boolean[] slash2, Stack<Integer> queenPosition,List<Stack<Integer>> answer) {
        if(y==n){
            answer.add(queenPosition);
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !slash1[y + i] && !slash2[y - i + n - 1]) {
                queenPosition.add(i);
                col[i] = true;
                slash1[y + i] = true;
                slash2[y - i + n - 1] = true;
                putQueen(n,y+1,col,slash1,slash2,queenPosition,answer);
                queenPosition.pop();
                col[i] = false;
                slash1[y + i] = false;
                slash2[y - i + n - 1] = false;
            }
        }
    }
}
