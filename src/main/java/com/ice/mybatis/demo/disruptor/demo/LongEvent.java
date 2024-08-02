package com.ice.mybatis.demo.disruptor.demo;

/**
 * @ClassName: LongEvent
 * @Description:
 * @Author: ice
 * @Date: 2021/6/12 14:30
 */
public class LongEvent {
    private long value;
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
