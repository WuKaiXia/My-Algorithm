package com.wk.javaalgorithm.leetcode283

import java.util.*

class SolutionK {

    fun moveZeroes1(nums: IntArray) {
        if (nums.size < 2) return
        var currentIndex = 0
        nums.forEachIndexed { index, value ->
            if (value != 0) {
                nums[currentIndex] = value
                if (currentIndex++ != index) {
                    nums[index] = 0
                }
            }
        }
    }
}