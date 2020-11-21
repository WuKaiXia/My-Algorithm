package com.wk.javaalgorithm.leetcode147

class SolutionK {

    internal fun insertionSortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val dummyHead = ListNode(0)
        dummyHead.next = head
        var lastSorted = head
        var curr = head.next
        while (curr != null && lastSorted != null) {
            if (lastSorted.`val` <= curr.`val`) {
                lastSorted = lastSorted.next
            } else {
                var prev: ListNode? = dummyHead
                while (prev?.next != null && prev.next!!.`val` <= curr.`val`) {
                    prev = prev.next
                }

                lastSorted.next = curr.next
                curr.next = prev?.next
                prev?.next = curr
            }
            curr = lastSorted?.next
        }
        return dummyHead.next
    }

    internal fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        val dummyHead = ListNode(0)
        var temp: ListNode? = dummyHead
        var temp1 = l1
        var temp2 = l2
        while (temp1 != null && temp2 != null) {
            if (temp1.`val` <= temp2.`val`) {
                temp?.next = temp1
                temp1 = temp1.next
            } else {
                temp?.next = temp2
                temp2 = temp2.next
            }
            temp = temp?.next
        }
        temp?.next = temp1 ?: temp2

        return dummyHead.next
    }
}


internal class ListNode(var `val`: Int) {
    var next: ListNode? = null
}