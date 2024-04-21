package com.resonit.multithreading;

public class TestShutDownHook {
    public static void main(String[] args) throws Exception {

        Runtime r = Runtime.getRuntime();

        r.addShutdownHook(new Thread(() -> System.out.println("shut down hook task completed..")));

        System.out.println("Now main sleeping... press ctrl+c to exit");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }
}