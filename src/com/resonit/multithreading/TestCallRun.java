package com.resonit.multithreading;

class TestCallRun extends Thread {
    public static void main(String[] args) {
        TestCallRun t1 = new TestCallRun();
        t1.run();   //fine, but does not start a separate call stack
    }

    public void run() {
        System.out.println("running...");
    }
}
