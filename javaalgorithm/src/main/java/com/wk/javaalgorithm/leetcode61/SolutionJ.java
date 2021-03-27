package com.wk.javaalgorithm.leetcode61;

import com.wk.javaalgorithm.leetcode147.ListNode;

import java.util.HashMap;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class SolutionJ {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        node.next = head;
        while (add-- > 0) {
            node = node.next;
        }
        ListNode res = node.next;
        node.next = null;
        return res;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        int count = 0;
        while (node != null) {
            map.put(count++, node);
            node = node.next;
        }
        int num = k % count;
        if (num == 0) {
            return head;
        }
        map.get(count - num - 1).next = null;
        ListNode res = map.get(count - num);
        ListNode currentNode = res;
        for (int i = count - num + 1; i < count; i++) {
            currentNode.next = map.get(i);
            currentNode = currentNode.next;
        }
        map.get(count - 1).next = head;
        return res;
    }
}
