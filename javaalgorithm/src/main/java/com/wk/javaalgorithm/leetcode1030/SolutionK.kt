package com.wk.javaalgorithm.leetcode1030

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.max

class SolutionK {

    fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray?> {
        val result = arrayOfNulls<IntArray>(R * C)
        for (i in 0 until R) {
            for (j in 0 until C) {
                result[i * C + j] = intArrayOf(i, j)
            }
        }
        result.sortBy { it?.let { dist(it[0], it[1], r0, c0) } ?: 0 }
//        Arrays.sort(result, object : Comparator<IntArray?> {
//            override fun compare(p0: IntArray?, p1: IntArray?): Int {
//                if (p0 == null || p1 == null) return 0
//                return dist(p0[0], p0[1], r0, c0) - dist(p1[0], p1[1], r0, c0)
//            }
//        })
        return result
    }

    fun allCellsDistOrder1(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray?> {
        val maxDist = max(r0, R - 1 - r0) + max(c0, C - 1 - c0)
        val list = arrayListOf<ArrayList<IntArray>>()

        for (i in 0..maxDist) {
            list.add(arrayListOf())
        }

        for (i in 0 until R) {
            for (j in 0 until C) {
                val dist = dist(i, j, r0, c0)
                list[dist].add(intArrayOf(i, j))
            }
        }

        val result = arrayOfNulls<IntArray>(R * C)
        var index = 0
        for (i in 0..maxDist) {
            list[i].forEach {
                result[index++] = it
            }
        }
        return result
    }


    fun dist(i: Int, j: Int, r0: Int, c0: Int): Int {
        return abs(i - r0) + abs(j - c0)
    }
}