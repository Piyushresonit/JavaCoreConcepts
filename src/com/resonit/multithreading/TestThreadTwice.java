package com.resonit.multithreading;

public class TestThreadTwice extends Thread {
    public static void main(String args[]) {
        TestThreadTwice t1 = new TestThreadTwice();
        t1.start();
        t1.start(); // can't start the same thread again (IllegalThreadStateException)
    }

    public void run() {
        System.out.println("running...");
    }
}
