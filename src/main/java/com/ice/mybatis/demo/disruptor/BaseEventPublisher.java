package com.ice.mybatis.demo.disruptor;

public interface BaseEventPublisher<T> {
    /**
     * Publish to the ring buffer. Use a Event Translator.
     *
     * @param t
     */
    void publish(T t);
}
