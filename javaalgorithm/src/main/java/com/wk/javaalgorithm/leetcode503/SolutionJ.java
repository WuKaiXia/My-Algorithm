package com.wk.javaalgorithm.leetcode503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 */
public class SolutionJ {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        int[] stack = new int[n];
        int top = -1;
        Arrays.fill(ret, -1);
        for (int i = 0; i < 2 * n - 1; i++) {
            int num = nums[i % n];
            while (top > -1 && num > nums[stack[top]]) {
                ret[stack[top--]] = num;
            }
            if (i < n) stack[++top] = i;
        }
        return ret;
    }


    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        Arrays.fill(ret, -1);
        for (int i = 0; i < 2 * n - 1; i++) {
            int num = nums[i % n];
            while (!deque.isEmpty() && num > nums[deque.peek()]) {
                ret[deque.pop()] = num;
            }
            deque.push(i % n);
        }
        return ret;
    }
}
