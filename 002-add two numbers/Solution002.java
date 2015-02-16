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

//Try1: 396ms
public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ll1 = l1, ll2 = l2, llc = result;
        int bonus = 0;
        while (ll1 != null || ll2 != null) {
            int value = 0;
            if (ll1 != null) {
                value += ll1.val;
                ll1 = ll1.next;
            }
            if (ll2 != null) {
                value += ll2.val;
                ll2 = ll2.next;
            }
            value += bonus;

            bonus = value / 10;
            llc.val = value % 10;
            if (ll1 != null || ll2 != null) {
                ListNode next = new ListNode(0);
                llc.next = next;
                llc = next;
            }
            else if (bonus != 0) {
                ListNode next = new ListNode(bonus);
                llc.next = next;
            }
        }

        return result;
    }
}
