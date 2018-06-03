package com.pillow;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestSortedMatrix {
    class Coordinate {
        int x, y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        List<Coordinate> corners = new ArrayList<>();
        corners.add(new Coordinate(0,0));
        int curVal = matrix[0][0];
        while (k-- > 0) {
            int min = Integer.MAX_VALUE;
            Coordinate curCorner = corners.get(0);
            for (Coordinate coord: corners) {
                if (matrix[coord.y][coord.x] < min) {
                    min = matrix[coord.y][coord.x];
                    curCorner = coord;
                }
            }

            curVal = min;
            corners.remove(curCorner);
            Coordinate curRight = null;
            Coordinate curDown = null;
            if (curCorner.x < matrix.length - 1)
                curRight = new Coordinate(curCorner.x + 1, curCorner.y);
            if (curCorner.y < matrix.length - 1)
                curDown = new Coordinate(curCorner.x, curCorner.y + 1);
            for (Coordinate coord: corners) {
                if (curRight != null && (coord.x == curRight.x && coord.y < curRight.y))
                    curRight = null;
                if (curDown != null && (coord.y == curDown.y && coord.x < curDown.x))
                    curDown = null;
            }
            if (curRight != null)
                corners.add(curRight);
            if (curDown != null)
                corners.add(curDown);
        }
        return curVal;
    }
}
