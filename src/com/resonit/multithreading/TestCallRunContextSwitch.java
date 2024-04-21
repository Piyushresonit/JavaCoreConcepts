package com.resonit.multithreading;

import java.util.Scanner;

public class TestCallRunContextSwitch extends Thread {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfThreads = sc.nextInt();

        for (int i = 0; i < numOfThreads; i++) {
            Thread thread = new Thread(new TestCallRunContextSwitch());
            thread.run();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread " + currentThread().getId() + " is running ");
    }
}
