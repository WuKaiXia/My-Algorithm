package com.wk.javaalgorithm.leetcode164

import java.util.*

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {

    }

    fun maximumGap(nums: IntArray?): Int {
        if (nums == null || nums.isEmpty()) return 0
        val size = nums.size
        var exp = 1L
        var buffer = IntArray(size)

        val maxValue = Arrays.stream(nums).max().asInt
        while (maxValue >= exp) {
            val cnt = IntArray(10)
            nums.forEach {
                val digit = (it / exp) % 10
                cnt[digit.toInt()]++
            }

            // 获取nums数组中export位数中 0-9每个数的数量的真实下标
            for (i in 1..9) {
                cnt[i] += cnt[i - 1]
            }

            for (i in (size - 1) downTo 0){
                val digit = (nums[i] / exp.toInt()) % 10
                buffer[cnt[digit] - 1] = nums[i]
                cnt[digit]--
            }
            System.arraycopy(buffer, 0, nums, 0, size)
            exp *= 10
        }
        var max = 0
        for (i in 1 until size) {
            val ret = nums[i] - nums[i - 1]
            if (ret > max) {
                max = ret
            }
        }
        return max
    }
}