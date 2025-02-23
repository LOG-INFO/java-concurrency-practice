package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class VirtualThreadSynchronizedTest {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        Tester tester = new Tester(executorService);
        tester.start();
    }
}