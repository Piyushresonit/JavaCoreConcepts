package com.resonit.multithreading;

import java.util.Scanner;

public class MyThreadImplRunnable implements Runnable{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfThreads = sc.nextInt();

        for (int i = 0; i < numOfThreads; i++) {
            Thread test = new Thread(new MyThreadImplRunnable());
            test.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " is running");
    }
}