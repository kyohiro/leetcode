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
        while (another != null && another.next != null) {
            head = head.next;
            another = another.next.next;
            if (head == another)
                return true;
        }
        
        return false;
    }
}