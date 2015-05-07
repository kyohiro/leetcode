/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution086 {
    //Attempt1: 291ms
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)        
            return head;

        ListNode current = head, last = new ListNode(0), result = last;
        while (current != null) {
            if (current.val < x) {
                last.next = new ListNode(current.val);
                last = last.next;
            }
            current = current.next;
        }

        current = head;
        while (current != null) {
            if (current.val >= x) {
                last.next = new ListNode(current.val);
                last = last.next;
            }
            current = current.next;
        }

        return result.next;
    }
}