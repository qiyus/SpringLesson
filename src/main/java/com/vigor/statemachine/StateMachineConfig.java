package com.vigor.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * Created by Vigor on 2017/11/4.
 */
@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderState, OrderEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> states) throws Exception {
        super.configure(states);
        states
                .withStates().
                initial(OrderState.UNPAID)
                .states(EnumSet.allOf(OrderState.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> transitions) throws Exception {
        super.configure(transitions);
        transitions
                .withExternal()
                .source(OrderState.UNPAID).target(OrderState.WAITING_FOR_RECEIVE).event(OrderEvent.PAY)
                .and()
                .withExternal()
                .source(OrderState.WAITING_FOR_RECEIVE).target(OrderState.DONE).event(OrderEvent.RECEIVE);
    }
}
