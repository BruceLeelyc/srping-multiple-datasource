### mybatis多数据源配置:
<br/>1.添加配置bean,通过@MapperScan扫描不同的dao包:
<br/>&nbsp;&nbsp;&nbsp;&nbsp; basePackages指向具体的包地址
<br/>&nbsp;&nbsp;&nbsp;&nbsp; sqlSessionFactoryRef引用bean中sessionFactory
<br/>&nbsp;&nbsp;&nbsp;&nbsp; 事例:@MapperScan(basePackages = {"com.lixl.mybatis.demo.dao.sys"}, sqlSessionFactoryRef = "sysSqlSessionFactory")
 - &nbsp;&nbsp;&nbsp;&nbsp; [sys]SqlSessionFactory sys对应properties文件中的sys配置
<br/>2.根目录添加mybatis.xml配置文件
### mybatis多数据源配置第二种配置:
<br/>1.添加配置application.properties,配置两个数据库连接地址
<br/>2.HikariProperties配置数据源加载属性类
<br/>3.DataSourceConfig配置数据源加载类:
    <br/>&nbsp;&nbsp;&nbsp;&nbsp; 指定数据源名称:@Bean(name = DataSourceUtils.DEFAULT_DB1)
    <br/>&nbsp;&nbsp;&nbsp;&nbsp; 指定数据源加载路径:@ConfigurationProperties(prefix = "spring.datasource.db1")
<br/>4.配置动态数据库切换类DynamicDataSource 继承 AbstractRoutingDataSource
<br/>5.创建业务数据切换工具类:DataSourceUtils
<br/>&nbsp;&nbsp;&nbsp;&nbsp; 事例:
<br/>&nbsp;&nbsp;&nbsp;&nbsp; 业务代码中切换数据源:DataSourceUtils.setDB(DataSourceUtils.DEFAULT_DB2);
