package com.vlamitin.otus.java.hw041gc.main;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

class GCStatisticsCollector {

    private static long POLL_INTERVAL = 2000;

    private static String YOUNG_GC_NAME = "G1 Young Generation";
    private static String OLD_GC_NAME = "G1 Old Generation";

    private long youngCollectionsCount = 0;

    private long youngCollectionsTime = 0;

    private long oldCollectionsCount = 0;

    private long oldCollectionsTime = 0;

    void start() {
        new java.util.Timer().schedule(
            new java.util.TimerTask() {
                @Override
                public void run() {
                    pollGC();
                    logInfo();
                    start();
                }
            },
            GCStatisticsCollector.POLL_INTERVAL
        );
    }

    private void pollGC() {
        final List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();

        gcBeans.forEach(bean -> {
            if (bean.getName().equals(GCStatisticsCollector.YOUNG_GC_NAME)) {
                youngCollectionsCount += bean.getCollectionCount();
                youngCollectionsTime += bean.getCollectionTime();
            } else if (bean.getName().equals(GCStatisticsCollector.OLD_GC_NAME)) {
                oldCollectionsCount += bean.getCollectionCount();
                oldCollectionsTime += bean.getCollectionTime();
            }
        });
    }

    private void logInfo() {
        System.out.println("YOUNG GC COUNT: " + youngCollectionsCount);
        System.out.println("YOUNG GC TIME: " + youngCollectionsTime);

        System.out.println("OLD GC COUNT: " + oldCollectionsCount);
        System.out.println("OLD GC TIME: " + oldCollectionsTime);
    }
}
