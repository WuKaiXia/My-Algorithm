package com.wk.javaalgorithm.leetcode91;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 */
public class SolutionJ {

    public int numDecodings(String s) {
        int n = s.length();
        // a=f[i-1] b = f[i-2] c=f[i]
        int a = 1, b = 0, c = 0;
        for (int i = 1; i <= n; i++) {
            c = 0;
            char c1 = s.charAt(i - 1);

            if (c1 != '0') {
                c += a;
            }
            if (i > 1) {
                char c2 = s.charAt(i - 2);
                if (c2 != '0' && ((c2 - '0') * 10 + (c1 - '0') <= 26)) {
                    c += b;
                }
            }
            b = a;
            a = c;
        }
        return c;
    }

    public int numDecodings1(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
