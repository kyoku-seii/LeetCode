package com.leetcode.question997;

import java.util.Arrays;

public class Solution {
    public int findJudge(int N, int[][] trust) {
        //根据信息绘制信任图
        int[][] trustMap = new int[N][N];
        for(int i=0;i<trust.length;i++){
            int[] trustPair = trust[i];
            int index_y = trustPair[0]-1;
            int index_x = trustPair[1]-1;
            trustMap[index_y][index_x]=1;
        }

        //遍历所有的行，找到可能存在的法官
        int[] a = new int[N];
        for(int i=0;i<trustMap.length;i++){
            if(Arrays.equals(trustMap[i],a)){
                //当前的i值即为法官
                //法官所在的列除了自己以外是否都为1
                for(int j=0;j<trustMap.length;j++){
                    if (j==i)
                        continue;
                    if(trustMap[j][i]!=1){
                        return -1;
                    }
                }
                return i+1;
            }
        }

        //没有找到符合条件的法官
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,3},{2,3}};
        System.out.println(solution.findJudge(3,arr));
    }
}
