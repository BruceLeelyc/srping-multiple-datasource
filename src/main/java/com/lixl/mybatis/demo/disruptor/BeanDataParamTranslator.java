package net.nicetuan.weapp.data.disruptor.translator;

import com.lmax.disruptor.EventTranslator;
import net.nicetuan.weapp.data.disruptor.model.DomainBeanDataStream;

/**
 * @author hanxiaowei
 */
public class DomainBeanDataStreamTranslator implements EventTranslator<DomainBeanDataStream> {

    private DomainBeanDataStream dataStream;

    public DomainBeanDataStreamTranslator(DomainBeanDataStream dataStream) {
        this.dataStream = dataStream;
    }

    @Override
    public void translateTo(DomainBeanDataStream dataStream, long sequence) {
        dataStream.setKey(this.dataStream.getKey());
        dataStream.setBean(this.dataStream.getBean());
        dataStream.setExpireSeconds(this.dataStream.getExpireSeconds());
    }
}
