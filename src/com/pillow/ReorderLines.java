package com.pillow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReorderLines {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        // WRITE YOUR CODE HERE
        List<String> alphaLines = new ArrayList<>();
        List<String> numLines = new ArrayList<>();
        for (int i = 0; i < logFileSize; i ++) {
            String s = logLines.get(i);
            String[] arr = s.split(" ");
            boolean alphaLine = false;
            try {
                Integer.parseInt(arr[1]);
            } catch (NumberFormatException e) {
                alphaLine = true;
            }
            if (alphaLine) {
                alphaLines.add(s);
            } else {
                numLines.add(s);
            }
        }
        alphaLines.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] arr1 = o1.split(" ");
                String[] arr2 = o2.split(" ");
                String id1 = arr1[0];
                String id2 = arr2[0];
                String t1 = o1.substring(id1.length());
                String t2 = o2.substring(id2.length());
                if (t1.compareTo(t2) > 0)
                    return 1;
                else if (t1.compareTo(t2) < 0)
                    return -1;
                else if (id1.compareTo(id2) > 0)
                    return 1;
                else if (id1.compareTo(id2) < 0)
                    return -1;
                else
                    return 0;
            }
        });

        alphaLines.addAll(numLines);
        return alphaLines;
    }
    // METHOD SIGNATURE ENDS
}
