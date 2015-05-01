/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //Attempt1: 324ms - loop twice
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)     
            return head;

        int length = 1;
        ListNode current = head.next, last = current;
        while (current != null) {
            last = current;
            current = current.next;
            ++length;
        }
        k = k % length;

        current = head;
        for (int i = 0; i < length - k - 1; ++i)
            current = current.next;
        last.next = head;
        last = current.next;
        current.next = null;
        return last;
    }

    //Attempt2: shortened version 
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            ++length;
            current = current.next;
        }
        k = k % length;
        current.next = head;
        current = head;

        for (int i = 0; i < length - k - 1; ++i) 
            current = current.next;
        ListNode ret = current.next;
        current.next = null;

        return ret;
    }
}