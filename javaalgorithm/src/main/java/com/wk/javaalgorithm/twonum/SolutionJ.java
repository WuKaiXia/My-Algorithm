package com.wk.javaalgorithm.twonum;

import java.util.HashMap;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 */
public class SolutionJ {

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(target - num, i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer index = map.getOrDefault(num, -1);
            if (index != -1 && index != i) {
                ret[0] = i;
                ret[1] = index;
                break;
            }
        }
        return ret;
    }

}
