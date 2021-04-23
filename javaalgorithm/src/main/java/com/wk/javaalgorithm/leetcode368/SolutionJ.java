package com.wk.javaalgorithm.leetcode368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 */
public class SolutionJ {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxSize = 1, maxVal = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (maxSize < dp[i]) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        if (maxSize == 1) {
            result.add(nums[0]);
            return result;
        }
        for (int i = n - 1; i >=0 && maxSize > 0 ; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                result.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return result;
    }
}
