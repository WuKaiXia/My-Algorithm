package com.wk.javaalgorithm.leetcode897;

import com.wk.javaalgorithm.leetcode222.TreeNode;

import java.util.ArrayList;

/**
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 */
public class SolutionJ {

    TreeNode resNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode treeNode = new TreeNode(-1);
        resNode = treeNode;
        inorder(root);
        return treeNode.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        resNode.right = root;
        root.left = null;
        resNode = resNode.right;
        inorder(root.right);
    }

    public TreeNode increasingBST1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode treeNode = new TreeNode(-1);
        TreeNode curr = treeNode;
        for (int num : list) {
            curr.right = new TreeNode(num);
            curr = curr.right;
        }
        return treeNode.right;
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.value);
        inorder(root.right, list);
    }
}
