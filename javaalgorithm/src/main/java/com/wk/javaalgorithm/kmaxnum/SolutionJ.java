package com.wk.javaalgorithm.kmaxnum;

/**
 * leetcode 215. 数组中的第K个最大元素
 */
public class SolutionJ {

    public int findKthLargest(int[] nums, int k) {
        return parition(nums, 0, nums.length - 1, nums.length - k);
    }

    private int parition(int[] nums, int left, int right, int k) {
        int pivot = left;
        int position = pivot + 1;
        for (int i = position; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                int temp = nums[position];
                nums[position] = nums[i];
                nums[i] = temp;
                position++;
            }
        }
        if (--position == k) {
            return nums[pivot];
        }
        int temp = nums[position];
        nums[position] = nums[pivot];
        nums[pivot] = temp;
        return position < k ? parition(nums, position + 1, right, k) : parition(nums,left, position - 1, k);
    }
}
