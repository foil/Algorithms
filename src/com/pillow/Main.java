package com.pillow;

import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception {
        Permutations permutations = new Permutations();
        int[] arr = new int[] {1,2,3};
        List<List<Integer>> res = permutations.permute(arr);
        System.out.print(res);
    }
}
