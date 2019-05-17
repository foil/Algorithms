package com.pillow;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < numCourses; i ++)
            l.add(new ArrayList<Integer>());
        for (int[] p: prerequisites) 
            l.get(p[0]).add(p[1]);

        int[] status = new int[l.size()];
        for (int i = 0; i < l.size(); i ++) {
            if (status[i] == 1)
                continue;
            if (!dfs(l, i, status))
                return false;
        }
        return true;
    }
    private static boolean dfs(List<List<Integer>> l, int i, int[] status) {
        if (status[i] == -1)
            return false;
        status[i] = -1;
        List<Integer> ll = l.get(i);
        for (int ii: ll) {
            if (status[ii] == 1)
                continue;
            if (!dfs(l, ii, status))
                return false;
        }
        status[i] = 1;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule s = new CourseSchedule();
        int[][] prerequisites = new int[][] {{1,0},{0,1}};
        System.out.println(s.canFinish(2, prerequisites));
    }
}
