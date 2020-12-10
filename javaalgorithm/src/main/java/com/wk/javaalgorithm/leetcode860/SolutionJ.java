package com.wk.javaalgorithm.leetcode860;


/**
 * 860. 柠檬水找零
 */
public class SolutionJ {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    fiveCount++;
                    break;
                case 10:
                    if (fiveCount < 1) {
                        return false;
                    }
                    fiveCount--;
                    tenCount++;
                    break;
                case 20:
                    if (tenCount > 0 && fiveCount > 0) {
                        fiveCount--;
                        tenCount--;
                    } else if (fiveCount > 2) {
                        fiveCount -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
