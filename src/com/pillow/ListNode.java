package com.pillow;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    static ListNode create(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i ++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }
    public String toString() {
        ListNode p = this;
        StringBuilder sb = new StringBuilder("[" + p.val);
        p = p.next;
        while (p != null) {
            sb.append(", " + p.val);
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

