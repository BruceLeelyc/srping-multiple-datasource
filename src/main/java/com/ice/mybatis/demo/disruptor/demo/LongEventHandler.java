package com.ice.mybatis.demo.disruptor.demo;

import com.lmax.disruptor.EventHandler;

/**
 * @ClassName: LongEventHandler
 * @Description:
 * @Author: ice
 * @Date: 2021/6/12 14:31
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("LongEventHandler="+longEvent.getValue());
    }
}
