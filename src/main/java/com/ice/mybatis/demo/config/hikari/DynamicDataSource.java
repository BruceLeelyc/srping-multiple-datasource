package com.ice.mybatis.demo.config.hikari;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName: DynamicDataSource
 * @Description:
 * @Author: dream
 * @Date: 2024/8/2 12:25
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceUtils.getDB();
    }
}
