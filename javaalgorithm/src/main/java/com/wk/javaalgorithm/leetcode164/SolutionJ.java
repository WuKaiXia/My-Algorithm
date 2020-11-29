package com.wk.javaalgorithm.leetcode164;

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * <p>
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
public class SolutionJ {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 9, 1};
        maximumGap(nums);
    }

    /**
     * 基于Arrays sort排序
     *
     * @param nums 原始数组
     * @return
     */
    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        return getMax(nums);
    }


    /**
     * 基数排序
     *
     * @param nums
     * @return
     */
    @SuppressWarnings("OverflowingLoopIndex")
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int length = nums.length;
        int[] buffer = new int[length];

        long export = 1;
        while (maxValue >= export) {
            // 该位是i的数的个数
            int[] cnt = new int[10];
            // 获取nums数组中export位数中 0-9每个数的个数
            for (int value : nums) {
                int digit = (value / (int) export) % 10;
                cnt[digit]++;
            }

            // 获取nums数组中export位数中 0-9每个数的数量的真实下标
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }

            for (int i = length - 1; i >= 0; i--) {
                // 倒序，获取i的digit
                int digit = (nums[i] / (int) export) % 10;
                // cnt[digit] - 1为export位digit数值的下标（从大到小），所以需倒序
                buffer[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buffer, 0, nums, 0, length);
            export *= 10;
        }

        return getMax(nums);
    }

    /**
     * 获取最大差值
     *
     * @param nums 排序后的数组
     * @return 获取最大差值
     */
    private static int getMax(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i + 1] - nums[i];
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
