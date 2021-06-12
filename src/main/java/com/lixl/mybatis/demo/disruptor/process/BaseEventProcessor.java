package net.nicetuan.weapp.data.disruptor.processor;

import com.google.common.collect.Maps;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.yhdx.tool.ctx.application.ApplicationContextHolder;
import com.yhdx.tool.log.domain.CommonLogger;
import com.yhdx.tool.log.util.LoggerUtils;
import com.yhdx.tool.lookout.NicetuanLookoutRegistry;
import com.yhdx.tool.lookout.NicetuanMetric;

import java.util.Map;

/**
 * @author hanxiaowei
 */
public abstract class BaseEventProcessor<T> implements EventHandler<T>, WorkHandler<T> {

    @Override
    public void onEvent(T dataStream, long sequence, boolean endOfBatch) throws Exception {
        NicetuanLookoutRegistry nicetuanLookoutRegistry  = null;
        try {
            nicetuanLookoutRegistry = ApplicationContextHolder.getBean(NicetuanLookoutRegistry.class);
        }catch (Exception e){
            LoggerUtils.error(CommonLogger.BIZ, e,"getBean NicetuanLookoutRegistry bean error");
            this.onEvent(dataStream);
        }
        if(nicetuanLookoutRegistry!=null) {
            String methodName = this.getClass().getSimpleName();
            Map<String, String> tags = Maps.newHashMap();
            tags.put("method", methodName);
            try {
                NicetuanMetric metric = nicetuanLookoutRegistry.createStarted("NicetuanWeappDataStreamEventAspectSuccess", tags);
                this.onEvent(dataStream);
                // 接口成功监控
                nicetuanLookoutRegistry.timerRecord(metric);
            } catch (Exception e) {
                // 接口失败监控
                nicetuanLookoutRegistry.counterInc("NicetuanWeappDataStreamEventAspectException", tags);
                throw new Exception(e);
            }
        }
    }

    @Override
    public abstract void onEvent(T dataStream) throws Exception;
}