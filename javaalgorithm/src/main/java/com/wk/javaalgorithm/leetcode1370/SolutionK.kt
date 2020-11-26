package com.wk.javaalgorithm.leetcode1370

class SolutionK {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            sortString("rat")
        }

        fun sortString(str: String?): String? {
            val length = str?.length ?: return str
            val letters = IntArray(26)
            str.forEach { c: Char ->
                letters[c - 'a']++
            }
            val ret = StringBuilder()
            while (ret.length < length) {
                letters.forEachIndexed { index, i ->
                    if (i > 0) {
                        ret.append('a'.plus(index))
                        letters[index]--
                    }
                }


                for (i in 25 downTo 0) {
                    val num = letters[i]
                    if (num > 0) {
                        ret.append('a'.plus(i))
                        letters[i]--
                    }
                }
            }
            return ret.toString()
        }
    }
}