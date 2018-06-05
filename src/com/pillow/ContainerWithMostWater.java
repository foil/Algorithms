package com.pillow;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int min = 0;
        int maxArea = 0;
        for (int l = 0, r = height.length - 1; l < r;) {
            if (height[l] < min)
                l++;
            else if (height[r] < min)
                r--;
            if (height[l] > height[r]) {
                min = height[r];
                int curArea = min * (r - l);
                if (curArea > maxArea)
                    maxArea = curArea;
                r--;
            } else {
                min = height[l];
                int curArea = min * (r - l);
                if (curArea > maxArea)
                    maxArea = curArea;
                l++;
                if (height[r] == min)
                    r--;
            }
        }
        return maxArea;
    }
}
