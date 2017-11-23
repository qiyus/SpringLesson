package com.vigor.statemachine;

import com.vigor.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by Vigor on 2017/11/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StateMachineTest {

    @Resource(name = "orderStateMachine")
    private StateMachine stateMachine;

    @Test
    public void orderProcess() throws Exception{
        stateMachine.start();
        stateMachine.sendEvent(OrderEvent.PAY);
        stateMachine.sendEvent(OrderEvent.RECEIVE);
    }
}