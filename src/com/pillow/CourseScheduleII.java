package com.pillow;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<HashSet<Integer>> l = new ArrayList<>();
        for (int i = 0; i < numCourses; i ++)
            l.add(new HashSet<Integer>());
        for (int[] p: prerequisites) 
            l.get(p[0]).add(p[1]);

        List<Integer> res = new ArrayList<>();
        boolean status[] = new boolean[numCourses];
        while (res.size() < numCourses) {
            boolean found = false;
            for (int i = 0; i < l.size(); i ++) {
                HashSet<Integer> set = l.get(i);
                if (set.size() == 0 && !status[i]) {
                    res.add(i);
                    status[i] = true;
                    found = true;
                    for (HashSet<Integer> s: l)
                        s.remove(i);
                }
            }
            if (!found)
                break;
        }
        return res.size() == numCourses? res.stream().mapToInt(i -> i).toArray(): new int[0];
    }

    public static void main(String[] args) {
        CourseScheduleII s = new CourseScheduleII();
        int[][] prerequisites = new int[][] {{1,0}, {2,0}, {3,1}, {3,2}};
        System.out.println(Arrays.toString(s.findOrder(4, prerequisites)));
    }
}
