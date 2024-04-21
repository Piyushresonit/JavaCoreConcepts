package com.resonit.multithreading;

class TestSleepMethod extends Thread {
    public static void main(String args[]) throws InterruptedException {
        TestSleepMethod t1 = new TestSleepMethod();
        TestSleepMethod t2 = new TestSleepMethod();
        TestSleepMethod t3 = new TestSleepMethod();

        t1.setName("ThreadObject1");
        t2.setName("ThreadObject2");
        t3.setName("ThreadObject3");
        t1.start();
        t1.join();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
        }
    }
}
