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
public class Solution160 {
    //Attempt1: 330ms
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode crtA = headA, crtB = headB;
        while (crtA != null) {
            ++lenA;
            crtA = crtA.next;
        }
        while (crtB != null) {
            ++lenB;
            crtB = crtB.next;
        }
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            for (int i = 0; i < diff; ++i) {
                headA = headA.next;
            }
        }
        else if (lenB > lenA) {
            for (int i = 0; i < diff; ++i)
                headB = headB.next;
        }
        
        while (headA != null) {
            if (headA == headB)
                return headA;
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        
        return null;
    }
}