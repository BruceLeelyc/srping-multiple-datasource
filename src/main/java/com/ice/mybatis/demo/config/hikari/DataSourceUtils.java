package com.ice.mybatis.demo.config.hikari;

/**
 * @ClassName: DataSourceUtils
 * @Description:
 * @Author: dream
 * @Date: 2024/8/2 12:26
 */
public class DataSourceUtils {

    public static final String DEFAULT_DB1 = "db1";
    public static final String DEFAULT_DB2 = "db2";

    private static final ThreadLocal<String> dbLocal = new ThreadLocal<>();

    public static void setDB(String dbType) {
        dbLocal.set(dbType);
    }

    public static String getDB() {
        return dbLocal.get();
    }

}
