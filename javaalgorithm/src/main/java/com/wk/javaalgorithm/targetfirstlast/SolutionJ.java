package com.wk.javaalgorithm.targetfirstlast;

/**
 * leetCode
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class SolutionJ {

    public static void main(String[] args) {
        int[] ints = {1};
        searchRange(ints, 1);
    }

    /**
     * 时间复杂度为O(logn)
     * @param nums   升序排列的数组
     * @param target
     * @return
     */
    public static int[] searchRange1(int[] nums, int target) {
        // 查找第一个大于等于target的数的index
        int leftIndex = binarySearch(nums, target, true);
        // 查找第一个大于target的数的index
        int rightIndex = binarySearch(nums, target, false) - 1;
        if (rightIndex >= leftIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        } else {
            return new int[]{-1, -1};
        }
    }

    private static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 时间复杂度为O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int minIndex = nums.length;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (target == num) {
                minIndex = Math.min(i, minIndex);
                maxIndex = Math.max(i, maxIndex);
            }
            // 优化
            if (i >= minIndex && i > maxIndex) {
                break;
            }
        }
        int[] ints = new int[2];
        if (maxIndex != -1) {
            ints[0] = minIndex;
            ints[1] = maxIndex;
        } else {
            ints[0] = -1;
            ints[1] = -1;
        }
        return ints;
    }
}
