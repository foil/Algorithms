package com.pillow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapSum {
    private Map<String, Integer> m;

    public MapSum() {
        m = new HashMap<>();
    }

    public void insert(String key, int val) {
        m.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry: m.entrySet()) {
            if (entry.getKey().startsWith(prefix))
                sum += entry.getValue();
        }
        return sum;
    }
}
