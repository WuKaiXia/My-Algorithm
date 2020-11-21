package com.wk.javaalgorithm.leetcode147;


/**
 * 147. 对链表进行插入排序
 */
public class SolutionJ {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode first = new ListNode(5);
        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        first.next = second;
        head.next = first;
        insertionSortList(head);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
