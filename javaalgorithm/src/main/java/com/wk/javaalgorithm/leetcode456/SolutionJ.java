package com.wk.javaalgorithm.leetcode456;

import java.util.TreeMap;

/**
 * 456. 132 模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 */
public class SolutionJ {
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        int leftMin = nums[0];
        TreeMap<Integer, Integer> rightAll = new TreeMap<>();
        for (int i = 2; i < length; i++) {
            rightAll.put(nums[i], rightAll.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 1; i < length - 1; i++) {
            int num = nums[i];
            if (leftMin < num) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < num) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, num);
            Integer integer = rightAll.get(nums[i + 1]);
            rightAll.put(nums[i + 1], --integer);
            if (integer <=0) {
                rightAll.remove(nums[i + 1]);
            }
        }
        return false;
    }
}
