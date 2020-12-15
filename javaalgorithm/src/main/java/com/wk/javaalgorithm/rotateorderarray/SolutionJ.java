package com.wk.javaalgorithm.rotateorderarray;

/**
 * 33. 搜索旋转排序数组
 */
public class SolutionJ {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) return mid;
            // 左侧为有序数组，反之右侧为有序数组
            if (nums[mid] > nums[right]) {
                // target在左区间，反之在右区间
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // target在右区间, 反之在左区间
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
