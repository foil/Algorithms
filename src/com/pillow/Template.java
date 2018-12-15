package com.pillow;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Template {
    private static final char[] map = new char[] {'0', 'a', 't', 'l', 's', 'i', 'n'};
    static String atlassian(int base) {
        StringBuilder sb = new StringBuilder();
        while (base > 0) {
            int d = base % 7;
            base = base / 7;
            sb.insert(0, map[d]);
        }
        return sb.toString();
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int base = scanner.nextInt();
        System.out.println(atlassian(base));
    }
}