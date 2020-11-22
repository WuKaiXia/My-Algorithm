package com.wk.javaalgorithm.leetcode148

import com.wk.javaalgorithm.leetcode147.ListNode

class SolutionK {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val head = ListNode(4)
            val first = ListNode(5)
            val second = ListNode(1)
            second.next = ListNode(3)
            first.next = second
            head.next = first
            insertionSortList(head)
        }

        fun insertionSortList(head: ListNode?): ListNode? {
            if (head?.next == null) return head
            var length = 0
            var node = head
            while (node != null) {
                length++
                node = node.next
            }

            val dummyHead = ListNode(0, head)

            var subLength = 1
            while (subLength < length) {
                var prev: ListNode? = dummyHead
                var curr = dummyHead.next
                while (curr != null) {
                    val head1 = curr

                    var i = 1
                    while (i++ < subLength && curr?.next != null) {
                        curr = curr.next
                    }

                    val head2 = curr?.next
                    curr?.next = null
                    curr = head2

                    i = 1
                    while (i++ < subLength && curr?.next != null) {
                        curr = curr.next
                    }
                    val next = curr?.next
                    curr?.next = null
                    curr = next
                    prev?.next = this.merge(head1, head2)
                    while (prev?.next != null) {
                        prev = prev.next
                    }
                }
                subLength = subLength shl 1
            }
            return dummyHead.next
        }

        private fun merge(head1: ListNode?, head2: ListNode?): ListNode? {
            if (head1 == null) return head2
            if (head2 == null) return head1
            val dummyHead = ListNode(0)
            var temp: ListNode? = dummyHead
            var temp1 = head1
            var temp2 = head2
            while (temp1 != null && temp2 != null) {
                if (temp1.`val` < temp2.`val`) {
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
}