#include <iostream>
#include "ListNode.h"

using namespace std;

class SwapNodesInPairs {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode* cur = head;
        int tmp;
        while (cur) {
            if (cur->next) {
                tmp = cur->val;
                cur->val = cur->next->val;
                cur->next->val = tmp;
                cur = cur->next->next;
            } else
                break;
        }
        return head;
    }
};

int main() {
    SwapNodesInPairs s;
    struct ListNode n1(1), n2(2), n3(3), n4(4);
    n1.next = &n2;
    n2.next = &n3;
    n3.next = &n4;
    
    ListNode* res = s.swapPairs(&n1);
    cout << res->val << endl;
}
