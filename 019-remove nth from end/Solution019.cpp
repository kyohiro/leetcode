class Solution019 {
public:
  //Attempt1: 9ms
  ListNode *removeNthFromEnd(ListNode *head, int n) {
    if (!head)
      return NULL;

    ListNode *tail = head;
    int i = 0;
    while (i++ < n) {
      tail = tail->next;
    }

    if (!tail) {
      return head->next;
    }

    ListNode *first = head;
    while (tail->next) {
      first = first->next;
      tail = tail->next;
    }

    first->next = first->next->next;
    return head;
  }
};
