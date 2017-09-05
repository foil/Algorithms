package com.pillow;

public class KthLargestNum {
    static void insertHeap(int[] heap, int n, int i) {
        int tmp;
        heap[i] = n;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heap[i] < heap[p]) {
                tmp = heap[p];
                heap[p] = heap[i];
                heap[i] = tmp;
            }
            i = p;
        }
    }
    static void updateHeap(int[] heap, int n) {
        if (n < heap[0])
            return;
        heap[0] = n;
        int p = 0, tmp;
        while (p < heap.length) {
            int i = p * 2 + 1;
            if (i < heap.length) {
                if (i + 1 < heap.length && heap[i] > heap[i + 1])
                    i = i + 1;
                if (heap[p] > heap[i]) {
                    tmp = heap[i];
                    heap[i] = heap[p];
                    heap[p] = tmp;
                }
                p = i;
            } else
                break;
        }
    }
    public static int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        heap[0] = nums[0];
        for (int i = 1; i < k; i ++)
            insertHeap(heap, nums[i], i);

        for (int i = k; i < nums.length; i ++)
            updateHeap(heap, nums[i]);

        return heap[0];
    }
}
