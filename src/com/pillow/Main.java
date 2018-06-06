package com.pillow;

public class Main {
    public static void main(String args[]) throws Exception {
        ContainerWithMostWater container = new ContainerWithMostWater();
        int[] height = new int[] {2,6,3,5,6,1,1};
        System.out.println(container.maxArea(height));
    }
}
