package com.vigor;

import com.vigor.redis.RedisTest;
import com.vigor.statemachine.StateMachineTest;
import com.vigor.task.AsyncTaskTest;
import com.vigor.web.controller.WebControllerTest;
import com.vigor.web.controller.UserControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.actuate.metrics.export.MetricExportProperties;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserControllerTest.class,
        WebControllerTest.class,
        RedisTest.class,
        StateMachineTest.class
})
public class ApplicationTests {
}
