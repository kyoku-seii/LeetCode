package com.leetcode.question207;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //以邻接表的形式保存图
        ArrayList<List<Integer>> graph = new ArrayList<>();
        //table中储存每个点的入度情况
        int[] table = new int[numCourses];
        Queue<Integer> queue =  new LinkedList<Integer>();
        //初始化图
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int j=0;j<prerequisites.length;j++){
            int[] pair = prerequisites[j];
            int postClass = pair[0];
            int preClass = pair[1];
            graph.get(preClass).add(postClass);
            table[postClass]++;
        }
        for(int k=0;k<numCourses;k++){
            if (table[k]==0)
                queue.add(k);//保存当前图中入读为0的点。
        }
        //不断地删除图中入度为0的点，直到queue为空
        while(!queue.isEmpty()){
            int delIndex = queue.poll();//要删除的点的编号
            numCourses--;
            List<Integer> delArr = graph.get(delIndex);
            for(int del:delArr){
                table[del]--;
                if (table[del]==0)
                    queue.add(del);
            }

        }
        return numCourses==0;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = new int[][]{{1,0},{3,0},{3,1},{2,1},{4,3},{4,2}};
        System.out.println(solution.canFinish(5,a));
    }
}
