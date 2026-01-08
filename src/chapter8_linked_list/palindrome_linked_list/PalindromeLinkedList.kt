package chapter8_linked_list.palindrome_linked_list

import java.util.Deque
import java.util.LinkedList

private fun isPalindrome(head: PalindromeLinkedList.ListNode?): Boolean {
    val deque: Deque<Int> = LinkedList()
    var node = head

    while (node != null) {
        deque.add(node.`val`)
        node = node.next
    }

    // 데크가 모두 비거나(짝수 개일 때) 1개 이하 (홀수 개일 때)가 될 때까지 비교
    while (!deque.isEmpty() && deque.size > 1) {
        // 데크의 양 끝을 추출해 팰린드롬 여부 확인
        if (deque.pollFirst() != deque.pollLast()) {
            return false
        }
    }

    return true
}