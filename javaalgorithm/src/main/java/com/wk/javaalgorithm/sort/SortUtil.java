package com.wk.javaalgorithm.sort;

import java.util.Arrays;

public class SortUtil {

    public static void main(String[] args) {
        SortUtil sortUtil = new SortUtil();
        int[] ints = {1, 2, 1, 4, 2, 5, 3, 6, 3};
        System.out.println("基数");
        for (int i : sortUtil.radixSort(ints)) {
            System.out.print(i+" ");
        }
        System.out.println("冒泡");
        for (int i : sortUtil.bubbleSort(ints)) {
            System.out.print(i+" ");
        }
        System.out.println("插入");
        for (int i : sortUtil.insertSort(ints)) {
            System.out.print(i+" ");
        }
    }
    /**
     * 冒泡排序
     *
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return nums;
    }

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    public int[] insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
        return nums;
    }

    /**
     * 基数排序
     *
     * @param nums
     * @return
     */
    public int[] radixSort(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        int length = nums.length;
        long exp = 1L;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int[] buffer = new int[length];
        while (maxValue >= exp) {
            int[] cnt = new int[10];
            for (int num : nums) {
                int digit = (int) ((num / exp) % 10);
                cnt[digit]++;
            }
            for (int i = 0; i < 9; i++) {
                cnt[i + 1] += cnt[i];
            }
            for (int i = length - 1; i >= 0; i--) {
                int num = nums[i];
                int digit = (int) ((num / exp) % 10);
                buffer[cnt[digit] - 1] = num;
                cnt[digit]--;
            }
            System.arraycopy(buffer, 0, nums, 0, length);
            exp *= 10;
        }
        return nums;
    }
}
