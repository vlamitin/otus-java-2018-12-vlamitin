package com.vlamitin.otus.java.hw041gc.main;

public class Main {

    public static void main(String[] args) {
        final Benchmark benchmark = new Benchmark();

        GCStatisticsCollector statisticsCollector = new GCStatisticsCollector();
        statisticsCollector.start();

        benchmark.setSize(10_000_000);
        benchmark.run();
    }

}
