/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution024 {
    //Attempt1: 203ms, non recursive
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head, second = head.next, ret = second, last = null;
        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            if (last != null)
                last.next = second;
            last = first;

            first = first.next;
            second = first != null ? first.next : null;
        }

        return ret;
    }

    //Attempt2: 168ms, recursive
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode second = head.next;
        head.next = swapPairs2(second.next);
        second.next = head;
        return second;
    }
}
