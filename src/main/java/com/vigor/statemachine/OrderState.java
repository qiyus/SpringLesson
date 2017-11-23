package com.vigor.statemachine;

/**
 * Created by Vigor on 2017/11/4.
 */
public enum OrderState {
    UNPAID,                 // 未支付
    WAITING_FOR_RECEIVE,    // 等待收货
    DONE                    // 交易完成
}
