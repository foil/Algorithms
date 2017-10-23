package com.pillow;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> main;
    private Stack<Integer> assist;

    public MinStack() {
        main = new Stack<>();
        assist = new Stack<>();
    }

    public void push(int x) {
        main.push(x);
        if (assist.empty())
            assist.push(x);
        else {
            int top = assist.peek();
            assist.push(x > top ? top : x);
        }
    }

    public void pop() {
        main.pop();
        assist.pop();
    }

    public int top() {
        return main.peek();
    }

    public int getMin() {
        return assist.peek();
    }
}
