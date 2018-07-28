package com.pillow;

import java.util.*;

public class MostFqWords {
    List<String> retrieveMostFrequentlyUsedWords(String literatureText,
                                                 List<String> wordsToExclude)
    {
        // WRITE YOUR CODE HERE
        List<String> l = new LinkedList<>(Arrays.asList(literatureText.split(" ")));
        l.removeAll(wordsToExclude);
        Map<String, Integer> m = new HashMap<>();
        for (String s: l) {
            if (m.containsKey(s)) {
                int v = m.get(s);
                m.put(s, v + 1);
            } else
                m.put(s, 1);
        }
        int max = 0;
        for (Object o : m.entrySet()) {
            Map.Entry p = (Map.Entry) o;
            if ((int) p.getValue() > max)
                max = (int) p.getValue();
        }
        List<String> res = new ArrayList<>();
        for (Object o: m.entrySet()) {
            Map.Entry p = (Map.Entry) o;
            if ((int) p.getValue() == max)
                res.add((String)p.getKey());
        }
        return res;
    }
    // METHOD SIGNATURE ENDS
}
