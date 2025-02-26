package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class Tester {
    private final ExecutorService executorService;
    private static final Logger logger = Logger.getLogger(Tester.class.getName());

    public Tester(ExecutorService executorService) {
        this.executorService = executorService;
    }

    static void nonSyncLog(int i, long startTimestamp) {
        log("non-sync", i, startTimestamp);
    }

    static synchronized void syncLog(int i, long startTimestamp) {
        log("sync", i, startTimestamp);
    }

    private static void log(String type, int i, long startTimestamp) {
        logger.info(String.format("[%s][%s][%d ms] Start: %d\n", type, Thread.currentThread().getName(), (System.currentTimeMillis() - startTimestamp),i));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info(String.format("[%s][%s][%d ms] End: %d\n", type, Thread.currentThread().getName(), (System.currentTimeMillis() - startTimestamp),i));
    }

    public void start() throws Exception {
        long startTimestamp = System.currentTimeMillis();
        int carrierThreadParallelism = ForkJoinPool.commonPool().getParallelism();
        System.out.println("carrierThreadParallelism: " + carrierThreadParallelism);

        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < carrierThreadParallelism * 2; i++) {
            int finalI = i;
            futures.add(executorService.submit(() -> Tester.syncLog(finalI, startTimestamp)));
            futures.add(executorService.submit(() -> Tester.nonSyncLog(finalI, startTimestamp)));
        }


        for (Future<?> future : futures) {
            future.get();
        }
    }
}
