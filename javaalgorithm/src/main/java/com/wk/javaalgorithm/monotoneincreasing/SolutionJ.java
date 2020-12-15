package com.wk.javaalgorithm.monotoneincreasing;

/**
 * 738. 单调递增的数字
 */
public class SolutionJ {

    public static void main(String[] args) {
        monotoneIncreasingDigits(10);
    }

    public static int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        char[] strN = Integer.toString(N).toCharArray();
        int length = strN.length;
        for (int i = length - 2; i > -1; i--) {
            if (strN[i] > strN[i + 1]) {
                strN[i]--;
                for (int j = i + 1; j < length; j++) {
                    strN[j] = '9';
                }
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
