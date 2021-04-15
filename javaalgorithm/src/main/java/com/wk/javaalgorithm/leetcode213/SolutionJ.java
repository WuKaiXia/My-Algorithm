package com.wk.javaalgorithm.leetcode213;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class SolutionJ {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(0, length - 1, nums), robRange(1, length, nums));
    }

    private int robRange(int start, int end, int[] nums) {
        int first = nums[start], second = Math.max(first, nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    private int robRange1(int start, int end, int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int i = start; i < end; i++) {
            if (i % 2 == 0) {
                sum1 += nums[i];
                sum1 = Math.max(sum1, sum2);
            } else {
                sum2 += nums[i];
                sum2 = Math.max(sum1, sum2);
            }
        }
        return Math.max(sum1, sum2);
    }
}
