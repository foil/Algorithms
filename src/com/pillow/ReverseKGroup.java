package com.pillow;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseKGroup {
    static ListNode reverse(ListNode head, ListNode tail) {
        ListNode p = head, n = head.next;
        while (n != tail) {
            ListNode tmp = n.next;
            n.next = p;
            p = n;
            n = tmp;
        }
        head.next = tail;
        return p;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;
        int n = 0;
        ListNode prev = head;
        while (p.next != null) {
            p = p.next;
            n ++;
            if (n % k == 0) {
                ListNode tmp = prev.next;
                prev.next = reverse(tmp, p.next);
                prev = p = tmp;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {};
        ListNode head = ListNode.fromArray(nums);
//        System.out.println(head.toString());
        ReverseKGroup s = new ReverseKGroup();
        head = s.reverseKGroup(head, 2);
//        System.out.println(head.toString());
    }
}
