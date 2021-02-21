package com.wk.javaalgorithm.leetcode1438;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 */
public class SolutionJ {

    public int longestSubarray1(int[] nums, int limit) {
        int ret = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int left = 0, right = 0;
        int length = nums.length;
        while (right < length) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[left], treeMap.getOrDefault(nums[left], 0) - 1);
                if (treeMap.get(nums[left]) <= 0) {
                    treeMap.remove(nums[left]);
                }
                left++;

            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}
