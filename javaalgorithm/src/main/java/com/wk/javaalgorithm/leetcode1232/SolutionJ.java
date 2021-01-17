package com.wk.javaalgorithm.leetcode1232;

/**
 * 1232. 缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 */
public class SolutionJ {

    /**
     * 一般式：Ax+By+C=0（AB≠0）
     * 两点式：(y-y1)/(x-x1)=(y-y2)/(x-x2) 　（直线过定点(x1,y1),(x2,y2)）
     * (y-y1)(x-x2) = (y-y2)(x-x1)
     * <p>
     * x = coordinates[0][0] y = coordinates[0][1]
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        for (int i = 1; i < len - 1; i++) {
            int res1 = (y - coordinates[i][1]) * (x - coordinates[i + 1][0]);
            int res2 = (y - coordinates[i + 1][1]) * (x - coordinates[i][0]);
            if (res1 != res2) return false;
        }
        return true;
    }

}
