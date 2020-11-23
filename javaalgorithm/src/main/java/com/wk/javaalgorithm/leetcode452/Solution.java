package com.wk.javaalgorithm.leetcode452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 */
public class Solution {

    public static void main(String[] args) {
        int[][] points = new int[2][2];
        points[0] = new int[]{-2147483646, -2147483645};
        points[1] = new int[]{2147483646, 2147483647};
        findMinArrowShots(points);

    }

    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (point1, point2) -> {
            // 避免差值过大而产生溢出
            return Integer.compare(point1[1], point2[1]);
        });
        int ans = 1;
        int point = points[0][1];
        for (int[] dot : points) {
            if (point < dot[0]) {
                point = dot[1];
                ans++;
            }
        }
        return ans;
    }
}
