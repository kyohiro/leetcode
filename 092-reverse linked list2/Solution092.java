/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution092 {
    //Attempt1: 272ms
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) 
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode before = dummy, after = head;

        int pos = 0;
        while (++pos < m) {
            before = before.next;
            after = after.next;
        }

        while (pos++ < n) {
            ListNode current = after.next;
            after.next = current.next;
            current.next = before.next;
            before.next = current;
        }

        return dummy.next;
    }
}