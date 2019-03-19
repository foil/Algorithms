package com.pillow;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SlidingWindowMedian{
    public double[] medianSlidingWindow(int[] nums, int k) {
        boolean even = (k % 2 == 0);
        int bottomSize = k / 2;
        PriorityQueue<Integer> topQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> bottomQ = new PriorityQueue<>();
        for (int i = 0; i < k; i ++) {
            bottomQ.add(nums[i]);
            if (bottomQ.size() > bottomSize)
                topQ.add(bottomQ.poll());
        }
        
        double[] medians = new double[nums.length - k + 1];
        double median;
        for (int i = k; i < nums.length; i ++) {
            if (even)
                median = (topQ.peek().doubleValue() + bottomQ.peek().doubleValue()) / 2;
            else
                median = topQ.peek().doubleValue();
            medians[i - k] = median;

            // System.out.printf("top: %s\n", Arrays.toString(topQ.toArray()));
            // System.out.printf("bottom: %s\n", Arrays.toString(bottomQ.toArray()));
            int rm = nums[i - k];
            if (bottomQ.contains(rm)) {
                bottomQ.remove(rm);
            } else {
                topQ.remove(rm);
            }

            if (nums[i] < median) {
                topQ.add(nums[i]);
                while (topQ.size() > k - bottomSize) {
                    bottomQ.add(topQ.poll());
                }
            } else {
                bottomQ.add(nums[i]);
                while (bottomQ.size() > bottomSize) {
                    topQ.add(bottomQ.poll());
                }
            }
        }
        
        if (even)
            median = (topQ.peek().doubleValue() + bottomQ.peek().doubleValue()) / 2;
        else
            median = topQ.peek().doubleValue();
        medians[nums.length - k] = median;
        
        return medians;
    }

    public static void main(String[] args) throws IOException {
    }
}
