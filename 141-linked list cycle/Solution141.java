/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode another = head;
        if (another != null && another.next != null && another.next != null && another.next.next != null)
            another = another.next.next;
        else
            return false;
        while (head != another) {
            if (head.next != null && another.next != null && another.next.next != null) {
                head = head.next;
                another = another.next.next;
            }
            else
                return false;
        }
        
        return true;
    }
}