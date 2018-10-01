package com.pillow;
import java.util.List;
import java.util.LinkedList;

public class Main {
    static void swap(int i, int j, int[] na) {
        int t = na[i];
        na[i] = na[j];
        na[j] = t;
    }

    static void quickSort(int l, int h, int[] A) {
        if (l < h) {
            int p = partition(A, l, h);
            quickSort(p + 1, h, A);
            quickSort(l, p - 1, A);
        }
    }
    static int partition(int[] A, int l, int h) {
        int i = l;
        int pivot = A[h];
        for (int j = i; j < h; j ++) {
            if (A[j] < pivot) {
                swap(i, j, A);
                i ++;
            }
        }
        swap(i, h, A);
        return i;
    }

    static ListNode mergeKLists(ListNode[] lists) {
        int K = lists.length;
        ListNode res = new ListNode(0);
        ListNode p = res;

        while (true) {
            boolean hasValue = false;
            int minVal = 0x7FFFFFFF;
            int minId = -1;
            for (int i = 0; i < K; i ++) {
                ListNode n = lists[i];
                if (n != null) {
                    hasValue = true;
                    if (n.val < minVal) {
                        minVal = n.val;
                        minId = i;
                    }
                }
            }
            if (!hasValue)
                return res.next;
            p.next = new ListNode(minVal);
            p = p.next;
            lists[minId] = lists[minId].next;
        }
    }

    public static void main(String args[]) throws Exception {
        ListNode[] lists = new ListNode[] {
            ListNode.create(new int[] {1,4,5}),
            ListNode.create(new int[] {1,3,4}),
            ListNode.create(new int[] {2,6})
        };
        ListNode res = Main.mergeKLists(lists);
        System.out.println(res.toString());
    }
}
