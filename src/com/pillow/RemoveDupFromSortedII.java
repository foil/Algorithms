package com.pillow;

public class RemoveDupFromSortedII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)  return null;
        ListNode prev = new ListNode(- 1);
        int tmp = head.val - 1;
        prev.next = head;
        head = prev;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == tmp) {
                cur = cur.next;
                continue;
            }

            if (cur.next == null || cur.val != cur.next.val) {
                // System.out.println(String.format("prev: %d, cur: %d, cur.next: %d", prev.val, cur.val, cur.next.val));
                prev.next = cur;
                prev = cur;
            }
            tmp = cur.val;
            cur = cur.next;
        }
        prev.next = cur;

        return head.next;
    }

    public static void main(String[] args) {
        RemoveDupFromSortedII s = new RemoveDupFromSortedII();
        ListNode l = ListNode.fromArray(new int[] {1,2,3,3,4,4,5});
        l = s.deleteDuplicates(l);
        System.out.println(l.toString());
    }
}
