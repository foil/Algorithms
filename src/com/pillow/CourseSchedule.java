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

        Set<Integer> skip = new HashSet<>();
        for (int i = 0; i < l.size(); i ++) {
            if (skip.contains(i))
                continue;
            skip.add(i);
            Set<Integer> visited = new HashSet<>();
            if (!dfs(l, i, skip, visited))
                return false;
        }
        return true;
    }
    private static boolean dfs(List<List<Integer>> l, int i,
            Set<Integer> skip, Set<Integer> visited) {
        if (visited.contains(i))
            return false;
        visited.add(i);
        List<Integer> ll = l.get(i);
        for (int ii: ll) {
            if (skip.contains(ii))
                continue;
            skip.add(ii);
            if (!dfs(l, ii, skip, visited))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule s = new CourseSchedule();
        int[][] prerequisites = new int[][] {{1,0},{0,1}};
        System.out.println(s.canFinish(2, prerequisites));
    }
}
