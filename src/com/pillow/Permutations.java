package com.pillow;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int n : nums) {
            if (result.isEmpty()) {
                List<Integer> l = new ArrayList<>();
                l.add(n);
                result.add(l);
            } else {
                int sz = result.size();
                for (int j = 0; j < sz; j++) {
                    List<Integer> l = result.get(j);
                    for (int k = 0; k < l.size(); k++) {
                        List<Integer> t = new ArrayList<>(l);
                        t.add(k, n);
                        result.add(t);
                    }
                    l.add(n);
                }
            }
        }
        return result;
    }
}
