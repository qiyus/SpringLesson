package com.vigor.task;

import com.vigor.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * Created by Vigor on 2017/10/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AsyncTaskTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void doAsyncTask() throws Exception {
        Long startTime = System.currentTimeMillis();

        Future<String> task1 = asyncTask.doOne();
        Future<String> task2 = asyncTask.doTwo();
        Future<String> task3 = asyncTask.doThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
            Thread.sleep(100);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("任务全部完成，总耗时%s毫秒。", endTime - startTime);
    }

}