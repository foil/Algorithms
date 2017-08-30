package com.pillow;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval. */
public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return String.format("[%d, %d]", start, end);
    }
}

class SummaryRanges {
    private List<Interval> intervalList;

    public SummaryRanges() {
        intervalList = new ArrayList<>();
    }

    public void addNum(int val) {
        int sz = intervalList.size();
        if (sz == 0)
            intervalList.add(new Interval(val, val));
        else {
            int start = 0, end = sz - 1, m;
            while (start <= end) {
                m = start + (end - start) / 2;
                Interval i = intervalList.get(m);
                if (i.start > val + 1) {
                    end = m - 1;
                } else if (i.end < val - 1) {
                    start = m + 1;
                } else if (i.start <= val && i.end >= val) {
                    //  merged
                    return;
                } else if (i.start == val + 1) {
                    if (m >= 1) {
                        Interval b = intervalList.get(m - 1);
                        if (b.end == val - 1) {
                            //  combine 2 intervals
                            i.start = b.start;
                            intervalList.remove(b);
                            return;
                        }
                    }
                    i.start = val;
                    return;
                } else if (i.end == val - 1) {
                    if (m + 1 < sz) {
                        Interval f = intervalList.get(m + 1);
                        if (f.start == val + 1) {
                            i.end = f.end;
                            intervalList.remove(f);
                            return;
                        }
                    }
                    i.end = val;
                    return;
                }
            }
            intervalList.add(start, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return intervalList;
    }
}
