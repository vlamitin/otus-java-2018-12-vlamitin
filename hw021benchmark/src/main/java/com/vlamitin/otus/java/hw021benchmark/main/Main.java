package com.vlamitin.otus.java.hw021benchmark.main;

public class Main {

    private final static long SIZE = 10_000_000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello!");

        long mem0 = getMemoryUsage();
        System.out.println("Initial memory usage: " + mem0);

        Object[] array = new Object[size];

        long mem2 = getMem();
        System.out.println("Ref size: " + (mem2 - mem) / array.length);
    }

    private static long getMemoryUsage() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
