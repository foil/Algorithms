package com.contest;

import java.util.concurrent.Semaphore;

public class Foo {
    private final Semaphore sem1 = new Semaphore(0);
    private final Semaphore sem2 = new Semaphore(0);
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sem1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sem1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        sem1.release();
        sem2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        sem2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        sem2.release();
    }

    public static void main(String args[]) {
        Foo foo = new Foo();
        try {
            foo.third(new Runnable() {
                @Override
                public void run() {
                    System.out.println("third");
                }
            });
            foo.first(new Runnable() {
                @Override
                public void run() {
                    System.out.println("first");
                }
            });
            foo.second(new Runnable() {
                @Override
                public void run() {
                    System.out.println("second");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
