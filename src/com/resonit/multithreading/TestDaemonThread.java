package com.resonit.multithreading;

public class TestDaemonThread extends Thread {
    public static void main(String[] args) {
        TestDaemonThread t1 = new TestDaemonThread();//creating thread
        TestDaemonThread t2 = new TestDaemonThread();
        TestDaemonThread t3 = new TestDaemonThread();

        t1.setDaemon(true);//now t1 is daemon thread

        t1.start();//starting threads
        t2.start();
        t3.start();
    }

    public void run() {
        if (Thread.currentThread().isDaemon()) {//checking for daemon thread
            System.out.println("daemon thread work");
        } else {
            System.out.println("user thread work");
        }
    }
}

