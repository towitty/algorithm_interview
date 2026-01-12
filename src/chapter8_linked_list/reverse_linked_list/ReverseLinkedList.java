package chapter8_linked_list.reverse_linked_list;

import chapter8_linked_list.palindrome_linked_list.PalindromeLinkedList.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
//        return recursiveSolution(head, null);
        return iterateSolution(head);
    }

    public ListNode recursiveSolution(ListNode node, ListNode prev) {
        if (node == null) {
            return prev;
        }

        // 현재 노드의 다음 노드 미리 지정
        ListNode next = node.next;
        // 현재 노드의 다음으로 이전 노드 지정
        node.next = prev;
        // 다음 노드와 현재 노드를 파라미터로 하여 재귀 호출
        return recursiveSolution(next, node);
    }

    public ListNode iterateSolution(ListNode head) {
        ListNode prev = null, node = head;
        // 노드 끝으로 이동할 때까지 순회
        while (node != null) {
            // 현재 노드의 다음 노드 미리 지정
            ListNode next = node.next;
            // 현재 노드의 다음으로 이전 노드 지정
            node.next = prev;
            // 이전 노드는 현재 노드로 지정
            prev = node;
            // 미리 지정했던 다음 노드를 현재 노드로 변경
            node = next;
        }
        // prev는 뒤집힌 연결 리스트의 첫 번째 노드
        return prev;
    }
}
