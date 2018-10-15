package com.pillow;

class TrappingRainWater {
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
                while (!stack.empty()) {
                    int t = stack.peek();
                    if (t <= r) {
                        res += (pr - pl) * t;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater s = new TrappingRainWater();
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.trap(height));
    }
};
