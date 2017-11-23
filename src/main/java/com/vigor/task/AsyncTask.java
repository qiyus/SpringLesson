package com.vigor.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by Vigor on 2017/10/29.
 */
@Component
public class AsyncTask {
    private static final Random random = new Random();

    @Async
    Future<String> doOne() throws InterruptedException {
        System.out.println("任务1开始。\n");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.printf("任务1结束，耗时%s毫秒。\n", endTime - startTime);
        return new AsyncResult<>("任务1完成");
    }

    @Async
    Future<String> doTwo() throws InterruptedException {
        System.out.println("任务2开始。\n");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.printf("任务2结束，耗时%s毫秒。\n", endTime - startTime);
        return new AsyncResult<>("任务2完成");
    }

    @Async
    Future<String> doThree() throws InterruptedException {
        System.out.println("任务3开始。\n");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.printf("任务3结束，耗时%s毫秒。\n", endTime - startTime);
        return new AsyncResult<>("任务3完成");
    }
}
