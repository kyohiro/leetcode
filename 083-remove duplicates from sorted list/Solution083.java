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
public class Solution {
    //Attempt1: 239ms
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode last = head;
        while (last.next != null) {
            if (last.val == last.next.val)
                last.next = last.next.next;
            else
                last = last.next;
        }

        return head;
    }
}
