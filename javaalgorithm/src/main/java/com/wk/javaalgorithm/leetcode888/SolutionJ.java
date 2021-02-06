package com.wk.javaalgorithm.leetcode888;

import com.wk.javaalgorithm.leetcode222.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 */
public class SolutionJ {

    /**
     * sumA + x - y = sumB - x + y
     *
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int dela = (sumA - sumB) / 2;
        HashSet<Integer> set = new HashSet<>();

        for (int i : A) {
            set.add(i);
        }
        for (int y : B) {
            int x = dela + y;
            if (set.contains(x)) {
                return new int[]{x, y};
            }
        }
        return new int[2];
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = null;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                if (node != null) {
                    res.add(node.value);
                }
            }
        }
        return res;

    }
}
