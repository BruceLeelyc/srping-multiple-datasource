package net.nicetuan.weapp.data.disruptor.processor;

import com.yhdx.tool.caching.redisson.RedissonCache;
import com.yhdx.tool.ctx.application.ApplicationContextHolder;
import com.yhdx.tool.log.domain.CommonLogger;
import com.yhdx.tool.log.util.LoggerUtils;
import net.nicetuan.weapp.data.disruptor.model.DomainBeanDataStream;

/**
 * @Description: HandpickDataStreamEventProcessor
 * @author: lixl
 * @Date: 2021/5/12 15:48
 */
public class HandpickDataStreamEventProcessor extends BaseEventProcessor<DomainBeanDataStream> {

    @Override
    public void onEvent(DomainBeanDataStream dataStream, long l, boolean b) throws Exception {
        LoggerUtils.info(CommonLogger.BIZ, " 接收到消息-----HandpickDataStream");
        super.onEvent(dataStream, l, b);
    }

    @Override
    public void onEvent(DomainBeanDataStream dataStream) throws Exception {
        LoggerUtils.info(CommonLogger.BIZ, ">>>notify>>>",dataStream.getKey()," bean class:",dataStream.getBean().getClass().getName());
        RedissonCache redissonCache = ApplicationContextHolder.getBean("selectedRedissonCache", RedissonCache.class);
        redissonCache.set(dataStream.getKey(), dataStream.getBean(),dataStream.getExpireSeconds());
    }
}
