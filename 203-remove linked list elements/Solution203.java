/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution203 {
    //Attempt1: 309ms
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;

        ListNode last = head, ret = last;
        if (last == null)
            return ret;
        else
            head = head.next;

        while (head != null) {
            if (head.val == val)
                last.next = head.next;
            if (last.next != null && last.next.val != val)
                last = last.next;
            head = head.next;
        }

        return ret;
    }
}