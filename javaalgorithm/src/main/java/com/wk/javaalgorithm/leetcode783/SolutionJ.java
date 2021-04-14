package com.wk.javaalgorithm.leetcode783;

import com.wk.javaalgorithm.leetcode222.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
public class SolutionJ {

    int min = Integer.MAX_VALUE;
    int pre = -1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            min = Math.min(min, root.value - pre);
        }
        pre = root.value;
        dfs(root.right);
    }
}
