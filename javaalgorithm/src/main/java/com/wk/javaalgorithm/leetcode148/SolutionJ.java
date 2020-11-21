package com.wk.javaalgorithm.leetcode148;

import com.wk.javaalgorithm.leetcode147.ListNode;

public class SolutionJ {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode first = new ListNode(5);
        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        first.next = second;
        head.next = first;
        sortList(head);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }

                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;

                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                    curr = next;
                }
                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummyHead.next;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                temp.next = temp2;
                temp2 = temp2.next;
            } else {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 != null ? temp1 : temp2;
        return dummyHead.next;
    }
}
