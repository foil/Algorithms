package com.pillow;

public class Main {
    public static void main(String args[]) throws Exception {
        String s = "())*()";
        boolean b = ValidParenthesisString.checkValidString(s);
        System.out.println(b);
    }
}
