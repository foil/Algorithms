package com.pillow;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FraudActNotif {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        boolean even = (d % 2 == 0);
        int bottomSize = d / 2;
        PriorityQueue<Integer> topQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> bottomQ = new PriorityQueue<>();
        for (int i = 0; i < d; i ++) {
            bottomQ.add(expenditure[i]);
        }
        while (bottomQ.size() > bottomSize)
            topQ.add(bottomQ.poll());

        int count = 0;
        float median;
        for (int i = d; i < expenditure.length; i ++) {
            if (even)
                median = (float)(topQ.peek() + bottomQ.peek()) / 2;
            else
                median = (float)topQ.peek();
            // System.out.println(median);
            if ((float)expenditure[i] >= median * 2)
                count ++;

            int rm = expenditure[i - d];
            if (bottomQ.contains(rm)) {
                bottomQ.remove(rm);
                if (expenditure[i] >= bottomQ.peek())
                    bottomQ.add(expenditure[i]);
                else {
                    topQ.add(expenditure[i]);
                    bottomQ.add(topQ.poll());
                }
            } else {
                topQ.remove(rm);
                if (expenditure[i] <= topQ.peek())
                    topQ.add(expenditure[i]);
                else {
                    bottomQ.add(expenditure[i]);
                    topQ.add(bottomQ.poll());
                }
            }
        }
        return count;
    }

    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        try {
            scanner = new Scanner(new File("src//input05.txt"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
