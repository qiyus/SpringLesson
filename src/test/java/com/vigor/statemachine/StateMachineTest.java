package com.vigor.statemachine;

import com.vigor.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static com.vigor.statemachine.OrderState.DONE;
import static com.vigor.statemachine.OrderState.UNPAID;
import static com.vigor.statemachine.OrderState.WAITING_FOR_RECEIVE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Vigor on 2017/11/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StateMachineTest {

    @Resource(name = "orderStateMachine")
    private StateMachine stateMachine;

    @Test
    public void start() throws Exception{
        stateMachine.start();
        assertThat(stateMachine.getState().getId(), is(UNPAID));
    }

    @Test
    public void pay() throws Exception {
        stateMachine.sendEvent(OrderEvent.PAY);
        assertThat(stateMachine.getState().getId(), is(WAITING_FOR_RECEIVE));
    }

    @Test
    public void receive() throws Exception {
        stateMachine.sendEvent(OrderEvent.RECEIVE);
        assertThat(stateMachine.getState().getId(), is(DONE));
    }
}