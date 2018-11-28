package com.pillow;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

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

    public boolean search(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i < j) {
            if (nums[i] < nums[j - 1])
                break;
            int m = i + (j - i) / 2;
            if (nums[m] > nums[i]) {
                i = m + 1;
                if (i == nums.length - 1)
                    break;
            } else if (nums[m] < nums[i])
                j = m;
            else
                i ++;
        System.out.println(i);
        }

        return bsearch(nums, 0, i, target) ||
            bsearch(nums, i, nums.length, target);
    }

    private boolean bsearch(int[] A, int i, int j, int t) {
        while (i < j) {
            int m = i + (j - i) / 2;
            if (A[m] < t)
                i = m + 1;
            else if (A[m] > t)
                j = m;
            else
                return true;
        }
        return false;
    }

    public static void main(String args[]) throws Exception {
        //int[] nums = new int[] {3,1}; int t = 3;
        //int[] nums = new int[] {3,5,1}; int t = 3;
        //int[] nums = new int[] {1,3,1,1,1}; int t = 3;
        //int[] nums = new int[] {1,1,2,2,0,0}; int t = 0;

        //System.out.println(new Main().search(nums, t));
        int x = 2147483647;
        for (int i = 1; ; i ++) {
            long s = (long)i * i;
            if (x == s) {
                System.out.println(i);
                break;
            }
            if (x < s) {
                System.out.println(i - 1);
                break;
            }
        }

    }
}
