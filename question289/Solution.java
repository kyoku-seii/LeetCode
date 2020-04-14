package com.leetcode.question289;

public class Solution {
    public void gameOfLife(int[][] board) {

        int y = board.length;
        int x = board[0].length;
        int[][] tempBoard = new int[y][x];

        int[] increateX = new int[]{0,0,-1,1,-1,1,-1,1};
        int[] increateY = new int[]{-1,1,0,0,-1,-1,1,1};

        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                int state = board[j][i];

                int alive = 0;
                for(int k=0;k<8;k++){
                    int tempX = i + increateX[k];
                    int tempY = j + increateY[k];
                    if(tempX<0||tempX>=x||tempY<0||tempY>=y)
                        continue;
                    if (board[tempY][tempX]==1){
                        alive++;
                    }
                }
                tempBoard[j][i] = upDate(state,alive);
            }
        }
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                board[j][i]=tempBoard[j][i];
            }
        }
    }

    private int upDate(int state, int alive) {
        if(state==1){
            if(alive<2){
                return 0;
            }else if(alive<=3){
                return 1;
            }else {
                return 0;
            }
        }
        else {
            if (alive==3){
                return 1;
            }else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
    };
        solution.gameOfLife(a);
    }
}
