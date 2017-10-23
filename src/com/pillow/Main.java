package com.pillow;

public class Main {
    public static void main(String args[]) throws Exception {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int a = obj.getMin();
        System.out.println(a);
        obj.pop();
        a = obj.top();
        System.out.println(a);
        a = obj.getMin();
        System.out.println(a);
    }
}
