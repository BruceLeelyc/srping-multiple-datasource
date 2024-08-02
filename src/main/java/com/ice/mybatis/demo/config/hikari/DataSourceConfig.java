package com.ice.mybatis.demo.config.hikari;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName: DataSourceConfig
 * @Description:
 * @Author: dream
 * @Date: 2024/8/2 12:17
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private HikariProperties hikariProperties;

    @Bean(name = DataSourceUtils.DEFAULT_DB1)
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource db1DataSource() {
        //return DataSourceBuilder.create().build();
        return getDataSource();
    }

    @Bean(name = DataSourceUtils.DEFAULT_DB2)
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource db2DataSource() {
        //return DataSourceBuilder.create().build();
        return getDataSource();
    }

    private HikariDataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setMinimumIdle(hikariProperties.getMinimumIdle());
        dataSource.setMaximumPoolSize(hikariProperties.getMaxPoolSize());
        dataSource.setAutoCommit(hikariProperties.isAutoCommit());
        dataSource.setIdleTimeout(hikariProperties.getMinIdleTimeOut());
        dataSource.setPoolName(hikariProperties.getPoolName());
        dataSource.setMaxLifetime(hikariProperties.getMaxLifetime());
        dataSource.setConnectionTimeout(hikariProperties.getConectionTimeOut());
        dataSource.setConnectionTestQuery(hikariProperties.getConnectionTestQuery());
        dataSource.setValidationTimeout(hikariProperties.getValidationTimeout());
        return dataSource;
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(db1DataSource());
        Map<Object, Object> dbMap = new HashMap<>();
        dbMap.put(DataSourceUtils.DEFAULT_DB1, db1DataSource());
        dbMap.put(DataSourceUtils.DEFAULT_DB2, db2DataSource());
        dynamicDataSource.setTargetDataSources(dbMap);
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
