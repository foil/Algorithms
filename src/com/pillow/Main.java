package com.pillow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception {
        MostFqWords m = new MostFqWords();
        String s = "r r a b c a d";
        List<String> c = new ArrayList<>();
        c.add("b");
        List<String> r = m.retrieveMostFrequentlyUsedWords(s, c);
        System.out.println(r);
    }
}
