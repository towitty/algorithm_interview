package chapter8_linked_list.reverse_linked_list

import chapter8_linked_list.palindrome_linked_list.PalindromeLinkedList.ListNode

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var node = head

    while (node != null) {
        val next = node.next
        node.next = prev
        prev = node
        node = next
    }

    return prev
}