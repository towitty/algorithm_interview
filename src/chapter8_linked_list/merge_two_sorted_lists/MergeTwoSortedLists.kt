package chapter8_linked_list.merge_two_sorted_lists

import chapter8_linked_list.palindrome_linked_list.PalindromeLinkedList.ListNode

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l1
    if (l2 == null) return l2

    return if (l1.`val` < l2.`val`) {
        l1.next = mergeTwoLists(l1.next, l2)
        l1
    } else {
        l2.next = mergeTwoLists(l1.next, l2)
        l2
    }
}