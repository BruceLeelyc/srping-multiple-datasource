mybatis多数据源配置:
<br/>1.添加配置bean,通过@MapperScan扫描不同的dao包:
<br/>&nbsp;&nbsp;&nbsp;&nbsp; basePackages指向具体的包地址
<br/>&nbsp;&nbsp;&nbsp;&nbsp; sqlSessionFactoryRef引用bean中sessionFactory
<br/>&nbsp;&nbsp;&nbsp;&nbsp; 事例:@MapperScan(basePackages = {"com.lixl.mybatis.demo.dao.sys"}, sqlSessionFactoryRef = "sysSqlSessionFactory")
<br/>2.根目录添加mybatis.xml配置文件
