package com.shieory.multithread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author shieory
 * @version : Task.java, v 0.1 2019年04月21日 15:24 shieory Exp $
 */
@Slf4j
@Component
public class Task {

    public static Random random = new Random();

    @Async("taskExecutor")
    public void doTaskOne() throws Exception {
        log.info(" start task one ");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("finish task one, spend time: " + (end - start) + "ms");
    }

    @Async("taskExecutor")
    public void doTaskTwo() throws Exception {
        log.info(" start task two ");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("finish task two, spend time: " + (end - start) + "ms");
    }

    @Async("taskExecutor")
    public void doTaskThree() throws Exception {
        log.info(" start task three ");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("finish task three, spend time: " + (end - start) + "ms");
    }
}
