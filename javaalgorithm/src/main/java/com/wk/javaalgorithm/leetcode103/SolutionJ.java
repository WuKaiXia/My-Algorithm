package com.wk.javaalgorithm.leetcode103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层序遍历
 */
public class SolutionJ {

    /**
     * 层序遍历, 输出每次节点数据
     * 广度优先-BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 添加到队列的末尾
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            // 循环本层的节点
            for (int i = 0; i < size; i++) {
                // 弹出头节点
                TreeNode node = queue.poll();
                list.add(node.val);
                // 判断是否需要添加该节点的左子节点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 判断是否需要添加该节点的右子节点
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        // 添加到队列的末尾
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            // 循环本层的节点
            for (int i = 0; i < size; i++) {
                // 弹出头节点
                TreeNode node = queue.poll();
                if (leftToRight) {
                    list.offerLast(node.val);
                } else {
                    list.offerFirst(node.val);
                }
                // 判断是否需要添加该节点的左子节点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 判断是否需要添加该节点的右子节点
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            leftToRight = !leftToRight;
            res.add(list);
        }
        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
