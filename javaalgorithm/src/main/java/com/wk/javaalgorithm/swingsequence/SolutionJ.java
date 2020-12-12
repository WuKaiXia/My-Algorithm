package com.wk.javaalgorithm.swingsequence;

/**
 * leetcode 376. 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列
 */
public class SolutionJ {

    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        // 长度为1的都为摆动序列
        if (length < 2) return length;
        // 记录相邻三个元素x,y,z(x和y的差值)
        int preDiff = nums[1] - nums[0];
        // 前两个元素是否重复
        int ret = preDiff != 0 ? 2 : 1;
        for (int i = 2; i < length; i++) {
            // 记录相邻三个元素x,y,z(y和z的差值)
            int diff = nums[i] - nums[i - 1];
            // 判断当前序列的上升下降趋势
            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                // 处于峰或者谷，结果加1
                ret++;
                // 更新当前序列的上升下降趋势
                preDiff = diff;
            }
        }
        return ret;
    }
}
