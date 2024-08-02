package com.ice.mybatis.demo.disruptor.demo;

import com.lmax.disruptor.EventFactory;

/**
 * @ClassName: LongEventFactory
 * @Description:
 * @Author: ice
 * @Date: 2021/6/12 14:31
 */
public class LongEventFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
