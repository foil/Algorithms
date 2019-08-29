package com.pillow;

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
        int[] range = find(intervals, newInterval);
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
        res[0] = i;
        for (; i < intervals.length; i ++) {
            if (intervals[i][1] > newInterval[1])
                break;
        }
        res[1] = i - 1;
        return res;
    }
}
