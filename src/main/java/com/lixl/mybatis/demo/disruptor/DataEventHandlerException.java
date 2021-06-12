package net.nicetuan.weapp.data.disruptor.exception;

import com.lmax.disruptor.ExceptionHandler;
import com.yhdx.tool.json.JsonUtils;
import com.yhdx.tool.log.domain.CommonLogger;
import com.yhdx.tool.log.util.LoggerUtils;

public class DataStreamEventHandlerException implements ExceptionHandler {
    @Override
    public void handleEventException(Throwable throwable, long sequence, Object event) {
        LoggerUtils.error(CommonLogger.BIZ, throwable.fillInStackTrace()," process data error sequence=",sequence," ,event=", JsonUtils.toJson(event));
        throwable.fillInStackTrace();
    }

    @Override
    public void handleOnStartException(Throwable throwable) {
        LoggerUtils.error(CommonLogger.BIZ, throwable.fillInStackTrace()," start disruptor error",throwable.getMessage());
    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {
        LoggerUtils.error(CommonLogger.BIZ, throwable.fillInStackTrace()," shutdown disruptor error",throwable.getMessage());
    }
}
