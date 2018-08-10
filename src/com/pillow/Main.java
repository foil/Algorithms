package com.pillow;

public class Main {
    public static void main(String args[]) throws Exception {
        MinRefuelingStops s = new MinRefuelingStops();
//        int target = 100, startFuel = 10;
//        int [][]stations = new int[][] {new int[]{10,60}, new int[]{20,30}, new int[]{30,30}, new int[]{60,40}};
//        int target = 100, startFuel = 25;
//        int [][]stations = new int[][] {new int[]{25,25},new int[]{50,25},new int[]{75,25}};
        int target = 1000, startFuel = 83;
        int [][]stations = new int[][] {new int[]{25,27},new int[]{36,187},new int[]{140,186},new int[]{378,6},new int[]{492,202},
                            new int[]{517,89},new int[]{579,234},new int[]{673,86},new int[]{808,53},new int[]{954,49}};

        int n = s.minRefuelStops(target, startFuel, stations);
        System.out.println(n);
    }
}
