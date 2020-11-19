package com.wk.javaalgorithm.leetcode283;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数
 */
public class Solution {

    public void moveZeroes1(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) <= 1) return;
        int currentIndex = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[currentIndex] = num;
                if (currentIndex++ != i) {
                    nums[i] = 0;
                }
            }
        }

    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int length = nums.length;

        int left = 0, right = 0;

        while (right < length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
