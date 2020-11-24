package com.wk.javaalgorithm.leetcode222;

/**
 * 222. 完全二叉树的节点个数
 */
public class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        // 最小节点数(最底层只有一个节点)
        int low = 1 << level;
        // 最大节点数(满二叉树)
        int high = (1 << (level + 1)) - 1;
        while(low < high) {
            // 左侧为满二叉树时所有子节点个数
            int mid = (high - low + 1) / 2 + low;
            // 存在mid节点,则总节点数>= mid
            if(exits(root, level, mid)) {
                low = mid;
            } else { // 不存在mid节点,则总结点数 < mid
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exits(TreeNode node, int level, int k) {
        int bits = 1 << (level - 1);
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

}
