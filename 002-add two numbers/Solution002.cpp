#include <stdio.h>

struct  ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

//Attempt1: 58ms
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode *head = new ListNode(0), *current = head;
        int step = 0;

        while (l1 != NULL || l2 != NULL || step != 0) {
            int value = step;
            if (l1 != NULL) {
                value += l1->val;
                l1 = l1->next;
            }
            if (l2 != NULL) {
                value += l2->val;
                l2 = l2->next;
            }

            current->val = value % 10;
            step = value / 10;
            if (l1 != NULL || l2 != NULL || step != 0) {
                ListNode *next = new ListNode(0);
                current->next = next;
                current = next;
            }
        }

        return head;
    }
};

int main() {
    return 0;
}

