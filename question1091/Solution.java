package com.leetcode.question1091;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;//行高与列高

        if(grid[0][0] == 1 || grid[m - 1][m - 1] == 1)return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        grid[0][0]=1;
        //len为当前层次的总节点个数
        int len = queue.size();
        int c =0; //记录一层内使用的节点
        int path = 1;

        while(!queue.isEmpty()){
            int[]temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            if(x==m-1&&y==m-1)return path;
            int[][] dir = {{1, 0}, {1, 1}, {1,-1}, {0, 1}, {0, -1}, {-1, 0},{-1, -1}, {-1, 1}};
            for(int[] t:dir){
                int x1 = t[1]+x;
                int y1 = t[0]+y;
                if(x1<m && y1<m &&x1>=0&&y1>=0&&grid[x1][y1]==0){
                    queue.add(new  int[]{x1,y1});
                    grid[x1][y1]=1;
                }
            }
            c++;
            if(c==len){
                c=0;
                path++;
                len=queue.size();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        Solution solution = new Solution();
        solution.shortestPathBinaryMatrix(a);
    }
}
