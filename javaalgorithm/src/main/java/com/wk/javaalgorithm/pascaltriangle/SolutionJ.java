package com.wk.javaalgorithm.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 118. 杨辉三角
 */
public class SolutionJ {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (numRows > 0) {
            ArrayList<Integer> row1 = new ArrayList<>();
            row1.add(1);
            list.add(row1);
            for (int i = 1; i < numRows; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                List<Integer> preList = list.get(i - 1);
                row.add(1);
                for (int j = 1; j < i; j++) {
                    row.add(preList.get(j - 1) + preList.get(j));
                }
                row.add(1);
                list.add(row);
            }
        }
        return list;
    }

}
