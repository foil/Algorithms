#include <iostream>
#include "ListNode.h"
using namespace std;
/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
*/
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* p = head;
        ListNode* last = NULL;
        while (n--) {
            p = p->next;
        }
        ListNode* rm = head;
        while (p) {
            p = p->next;
            last = rm;
            rm = rm->next;
        }
        if (last) {
            last->next = rm->next;
            return head;
        }
        return rm->next;
    }
};

int main() {
    Solution s;
    ListNode h1(1), h2(2), h3(3), h4(4), h5(5);
    h1.next = &h2, h2.next = &h3, h3.next = &h4, h4.next = &h5;
    ListNode *p = s.removeNthFromEnd(&h1, 2);
    while (p) {
        cout << p->val << endl;
        p = p->next;
    }
}
