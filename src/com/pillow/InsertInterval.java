package com.pillow;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/*
   Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

   You may assume that the intervals were initially sorted according to their start times.

   Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/
class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) {
            res.add(newInterval);
            return res.toArray(new int[0][0]);
        }
        int[] range = find(intervals, newInterval);
        if (range[0] == -1) {
            if (range[1] == intervals.length)
                res.add(newInterval);
            else {
                int[] tmp = new int[2];
                tmp[0] = newInterval[0];
                tmp[1] = intervals[range[1]][1];
                res.add(tmp);
                for (int i = range[1] + 1; i < intervals.length; i ++)
                    res.add(intervals[i]);
            }
        } else if (range[1] == range[0]) {
            return intervals;
        } else if (newInterval[1] < intervals[range[1]][0] && newInterval[0] > intervals[range[0]][1]) {
            for (int i = 0; i <= range[0]; i ++)
                res.add(intervals[i]);
            res.add(newInterval);
            for (int i = range[1]; i < intervals.length; i ++)
                res.add(intervals[i]);
        } else if (newInterval[0] > intervals[range[0]][1]) {
            for (int i = 0; i <= range[0]; i ++)
                res.add(intervals[i]);
            int[] tmp = new int[2];
            tmp[0] = newInterval[0];
            tmp[1] = intervals[range[1]][1];
            res.add(tmp);
            for (int i = range[1] + 1; i < intervals.length; i ++)
                res.add(intervals[i]);
        } else if (newInterval[1] < intervals[range[1]][0]) {
            for (int i = 0; i < range[0]; i ++)
                res.add(intervals[i]);
            int[] tmp = new int[2];
            tmp[0] = intervals[range[0]][0];
            tmp[1] = newInterval[1];
            res.add(tmp);
            for (int i = range[1]; i < intervals.length; i ++)
                res.add(intervals[i]);
        } else {
            for (int i = 0; i < range[0]; i ++)
                res.add(intervals[i]);
            int[] tmp = new int[2];
            tmp[0] = intervals[range[0]][0];
            tmp[1] = intervals[range[1]][1];
            res.add(tmp);
            for (int i = range[1] + 1; i < intervals.length; i ++)
                res.add(intervals[i]);
        }
        return res.toArray(new int[0][0]);
    }

    private int[] find(int[][] intervals, int[] newInterval) {
        //  find out the indexes for such 2 intervals in the intervals list:
        //  interval 1: the first interval with start >= newInterval.start
        //  interval 2: the last interval with end <= newInterval.end
        int[] res = new int[] {-1, -1};
        int i = 0;
        for (; i < intervals.length; i ++) {
            if (intervals[i][0] >= newInterval[0])
                break;
        }
        i -= 1;
        res[0] = i;
        for (; i < intervals.length; i ++) {
            if (i < 0)
                continue;
            if (intervals[i][1] >= newInterval[1])
                break;
        }
        res[1] = i;
        return res;
    }

    public static void main(String[] args) {
        InsertInterval s = new InsertInterval();
        //int[][] intervals = new int[][] {{1,3},{6,9}}; int[] newInterval = new int[] {2,5};
        //Output: [[1,5],[6,9]]
        //int[][] intervals = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}; int[] newInterval = new int[] {4,8};
        //Output: [[1,2],[3,10],[12,16]]
        int[][] intervals = new int[][] {{1,5}}; int[] newInterval = new int[] {2,7};
        //Output: [[1,7]]
        int[][] res = s.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res));
    }
}
