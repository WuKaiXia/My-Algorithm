package com.wk.javaalgorithm.leetcode26;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class SolutionJ {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (nums[result] != nums[i]) {
                nums[++result] = nums[i];
            }
        }
        return result + 1;
    }
}
