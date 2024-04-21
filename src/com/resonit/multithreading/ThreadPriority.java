package com.resonit.multithreading;

public class ThreadPriority extends Thread {
    public static void main(String args[]) {
        ThreadPriority t1 = new ThreadPriority();
        ThreadPriority t2 = new ThreadPriority();

        try {
            t1.setName("ThreadObject1");
            t2.setName("ThreadObject2");
            t1.setPriority(MAX_PRIORITY);
            t2.setPriority(MIN_PRIORITY);
            t1.start();
            t2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            System.out.println("Thread " + Thread.currentThread().getName() + " priority is " + Thread.currentThread().getPriority());
        }
    }
}