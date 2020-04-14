package com.leetcode.question1137;

public class Solution3 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int x, y, z;
        x = 0;
        y = 1;
        z = 1;
        int result = x + y + z;

        for (int i = 3; i < n; i++) {
            x = y;
            y = z;
            z = result;
            result = x + y + z;
        }
        return result;
    }
}
