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

//Attempt1: 396ms
//Attempt2: 417ms
public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), current = head;
        int step = 0;

        while (l1 != null || l2 != null || step != 0) {
            int value = step;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }

            step = value / 10;
            current.val = value % 10;
            if (l1 != null || l2 != null || step != 0) {
                ListNode next = new ListNode(0);
                current.next = next;
                current = next;
            }
        }

        return head;
    }
}
