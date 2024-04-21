package com.resonit.multithreading;

class NewThread implements Runnable {
    public NewThread() {
        Thread t = new Thread(this, "DemoThread");
        System.out.println("Child thread: " + t);
        t.start(); // Start the thread
    }

    public void run() {
        try {
            for (int i = 3; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

class ThreadDemo {
    public static void main(String args[]) {
        new NewThread(); // create a new thread
        try {
            for (int i = 3; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}