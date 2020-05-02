package com.leetcode.question51;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        if(n<1){
            List<List<String>> answer = new ArrayList<>();
            answer.add(Collections.emptyList());
            return answer;
        }

        List<List<String>> list = new ArrayList<>();
        List<Boolean> col = new ArrayList<>(n);
        for (int j = 0; j < n; j++) col.add(j,false);

        List<Boolean> dia1 = new ArrayList<>(2 * n - 1);
        for (int j = 0; j < 2 * n - 1; j++) dia1.add(j, false);

        List<Boolean> dia2 = new ArrayList<>(2 * n - 1);
        for (int j = 0; j < 2 * n - 1; j++) dia2.add(j,false);

        List<Integer> row = new ArrayList<>();//存放皇后的位置
        putQueen(n, 0, row, col, dia1, dia2, list);

        return list;

    }

    // 尝试在一个n皇后的问题中，摆放第index行的皇后位置
    private void putQueen(int n, int index, List<Integer> row, List<Boolean> col, List<Boolean> dia1, List<Boolean> dia2, List<List<String>> list) {

        if (index == n) {
            list.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 尝试将第index行的皇后摆放在第i列
            if (!col.get(i) && !dia1.get(index + i) && !dia2.get(index - i + n - 1)) {
                row.add(i);
                col.set(i, true);
                dia1.set(index + i, true);
                dia2.set(index - i + n - 1, true);
                putQueen(n, index + 1, row, col, dia1, dia2, list);
                col.set(i, false);
                dia1.set(index + i, false);
                dia2.set(index - i + n - 1, false);
                row.remove(row.size() - 1);
            }
        }

    }

    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int qPosition = row.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == qPosition) sb.append('Q');
                else sb.append('.');
            }
            answer.add(sb.toString());
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
    }
}
