package com.wk.javaalgorithm.leetcode220;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 */
public class SolutionJ {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }


    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            long before = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                boolean isT = false;
                long result = Math.abs((long) nums[j] - before);
                if (result <= t) {
                    isT = true;
                }
                if (isT && (j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
