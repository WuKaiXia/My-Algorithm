package com.wk.javaalgorithm.kmaxnum;

import java.util.Random;

/**
 * leetcode 215. 数组中的第K个最大元素
 */
public class SolutionJ {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int partitionIndex = randomPartition(nums, left, right);
        if (partitionIndex == k) {
            return nums[partitionIndex];
        }
        return partitionIndex < k ? quickSelect(nums, partitionIndex + 1, right, k) : quickSelect(nums, left, partitionIndex - 1, k);
    }

    /**
     * 随机数的选择，一定程度上避免时间复杂度的退化
     */
    private int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, i, left);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = left;
        int position = pivot + 1;
        for (int i = position; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, position, i);
                position++;
            }
        }
        swap(nums, position - 1, pivot);
        return position - 1;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
