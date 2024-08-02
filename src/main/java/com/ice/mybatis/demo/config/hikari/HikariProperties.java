package com.ice.mybatis.demo.config.hikari;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: HikariConfigProperties
 * @Description:
 * @Author: dream
 * @Date: 2024/8/2 15:20
 */
@Configuration
public class HikariProperties {

    // com.zaxxer.hikari.HikariDataSource
    @Value("${spring.datasource.type}")
    private String type;
    @Value("${spring.datasource.hikari.minimum-idle}")
    private int minimumIdle;
    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int maxPoolSize;
    @Value("${spring.datasource.hikari.auto-commit}")
    private boolean isAutoCommit;
    @Value("${spring.datasource.hikari.idle-timeout}")
    private int minIdleTimeOut;
    @Value("${spring.datasource.hikari.pool-name}")
    private String poolName;
    @Value("${spring.datasource.hikari.max-lifetime}")
    private long maxLifetime;
    @Value("${spring.datasource.hikari.connection-timeout}")
    private long conectionTimeOut;
    @Value("${spring.datasource.hikari.connection-test-query}")
    private String connectionTestQuery;
    @Value("${spring.datasource.hikari.validation-timeout}")
    private long validationTimeout;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinimumIdle() {
        return minimumIdle;
    }

    public void setMinimumIdle(int minimumIdle) {
        this.minimumIdle = minimumIdle;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public boolean isAutoCommit() {
        return isAutoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        isAutoCommit = autoCommit;
    }

    public int getMinIdleTimeOut() {
        return minIdleTimeOut;
    }

    public void setMinIdleTimeOut(int minIdleTimeOut) {
        this.minIdleTimeOut = minIdleTimeOut;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public long getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(long maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public long getConectionTimeOut() {
        return conectionTimeOut;
    }

    public void setConectionTimeOut(long conectionTimeOut) {
        this.conectionTimeOut = conectionTimeOut;
    }

    public String getConnectionTestQuery() {
        return connectionTestQuery;
    }

    public void setConnectionTestQuery(String connectionTestQuery) {
        this.connectionTestQuery = connectionTestQuery;
    }

    public long getValidationTimeout() {
        return validationTimeout;
    }

    public void setValidationTimeout(long validationTimeout) {
        this.validationTimeout = validationTimeout;
    }
}
