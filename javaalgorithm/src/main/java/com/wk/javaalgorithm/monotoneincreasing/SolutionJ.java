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
                    if (strN[j] == '9') {
                        break;
                    }
                    strN[j] = '9';
                }
            }
        }
        return Integer.parseInt(new String(strN));
    }

    public static int monotoneIncreasingDigits1(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int length = strN.length;
        int i = 1;
        // 高位<低一位的数
        while (i < length && strN[i - 1] <= strN[i]) {
            i++;
        }
        if (i < length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[--i]--;
            }
            for (i += 1; i < length; i++) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
