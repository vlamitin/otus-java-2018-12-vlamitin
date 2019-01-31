package com.vlamitin.otus.java.hw041gc.main;

class Benchmark {
    private volatile int size = 0;

    @SuppressWarnings("InfiniteLoopStatement")
    void run() {

        System.out.println("Starting the loop");
        while (true) {
            final int local = size;
            final Object[] arr = new Object[local];

            for (int i = 0; i < local; i++) {
                arr[i] = new String(new char[0]);
            }
        }
    }

    int getSize() {
        return size;
    }

    void setSize(int size) {
        this.size = size;
    }
}
