package com.pillow;
import java.util.Set;
import java.util.HashSet;

class TrappingRainWater {
    /*
    public int trap(int[] height) {
        int pl = 0, pr = 1; res = 0;
        Stack<Integer> stack = new Stack<>();
        while (pr < height.length) {
            int l = height[pl], r = height[pr];
            if (r < l) {
                stack.push(l);
                pl ++; pr ++;
            } else if (r == l) {
                pr ++;
            } else {
                int b = l;
                while (!stack.empty()) {
                    int t = stack.peek();
                    if (t <= r) {
                        res += (pr - pl - 1) * (t - b);
                        b = t;
                        stack.pop();
                    } else {
                        res += (pr - pl - 1) * (r - b);
                        b = r;
                        pr ++;
                    }
                }
            }
        }
        return res;
    }*/

    public int trap(int[] height) {
        if (height.length == 0)
            return 0;

        int max = height[0], p = 0, res = 0;
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i < height.length; i ++) {
            if (height[i] >= max) {
                res += calc(height, p, i);
                max = height[i];
                p = i;
                s.add(i);
            }
        }
        p = height.length - 1; max = height[p];
        for (int i = height.length - 2; i >= 0; i --) {
            if (height[i] >= max && !s.contains(p)) {
                res += calc(height, i, p);
                max = height[i];
                p = i;
            }
        }
        return res;
    }

    private int calc(int[] A, int pl, int pr) {
        int l = A[pl], r = A[pr];
        int min = l < r? l: r;
        int walls = 0;
        for (int i = pl + 1; i < pr; i ++)
            walls += A[i];

        int res = (pr - pl - 1) * min - walls;
        System.out.println(String.format(
                    "l: %d, r: %d, walls: %d, res: %d",
                    pl, pr, walls, res));
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater s = new TrappingRainWater();
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.trap(height));
    }
};
