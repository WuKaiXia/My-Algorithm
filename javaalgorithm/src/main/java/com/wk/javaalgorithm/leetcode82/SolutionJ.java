package com.wk.javaalgorithm.leetcode82;

import com.wk.javaalgorithm.leetcode147.ListNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 */
public class SolutionJ {

    public static void main(String[] args) {

        ListNode head6 = new ListNode(5);
        ListNode head5 = new ListNode(4, head6);
        ListNode head4 = new ListNode(4, head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(3, head3);
        ListNode head1 = new ListNode(2, head2);
        ListNode head = new ListNode(1, head1);
        SolutionJ solutionJ = new SolutionJ();
        solutionJ.deleteDuplicates2(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode currentNode = dummy;
        while (currentNode.next != null && currentNode.next.next != null) {
            if (currentNode.next.val == currentNode.next.next.val) {
                int x = currentNode.next.val;
                while (currentNode.next != null && currentNode.next.val == x) {
                    currentNode.next = currentNode.next.next;
                }
            } else {
                currentNode = currentNode.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            node = node.next;
        }
        node = head;
        while (node != null) {
            Integer num = map.get(node.val);
            if (num == 1) {
                list.add(node);
            }
            node = node.next;
        }
        ListNode res = null;
        if (!list.isEmpty()) {
            res = list.get(0);
            node = res;
            for (int i = 1; i < list.size(); i++) {
                node.next = list.get(i);
                node = node.next;
            }
            node.next = null;
        }
        return res;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode node = head;
        while (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            node = node.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;
        node = head;
        while (node != null) {
            Integer num = map.get(node.val);
            if (num == 1) {
                currentNode.next = node;
                currentNode = currentNode.next;
            }
            node = node.next;
        }
        currentNode.next = null;
        return dummy.next;
    }
}
