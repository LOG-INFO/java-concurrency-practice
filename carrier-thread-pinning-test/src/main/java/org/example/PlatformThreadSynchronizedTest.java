package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PlatformThreadSynchronizedTest {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newThreadPerTaskExecutor(Thread.ofPlatform().factory());
        Tester tester = new Tester(executorService);
        tester.start();
    }
}