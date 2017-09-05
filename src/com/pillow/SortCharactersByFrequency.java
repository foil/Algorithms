package com.pillow;

import java.util.*;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        if (s == null || s.isEmpty())
            return s;
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            Integer v = map.putIfAbsent(c, 1);
            if (v != null)
                map.put(c, v + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
