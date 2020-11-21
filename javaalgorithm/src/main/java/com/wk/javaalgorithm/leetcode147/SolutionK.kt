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
                var prev:ListNode? = dummyHead
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
}


internal class ListNode(var `val`: Int) {
    var next: ListNode? = null
}