# spb-security-mybatis

一、持久层使用mybatis框架，其他和jpa实现security项目一致

二、spring.datasource.*的配置

application.properties配置文件中，spring.datasource.*会被springboot自动加载，数据源就会自动注入sqlSessionFactory,sqlSessionFactory会自动入住Mapper。

三、UserMapper和JPA中的UserRepository作用完全一致，区别在于JPA自动生成sql语句，而mybatis需要自己写sql语句

四、在appmain启动函数中，类名上增加：
     
     // 扫描数据访问层接口的包名。
      @MapperScan("com.wangzhen.spbsecuritymybatis.mapper")
      
作用是让spring能够扫描该包下面的所有mybatis的Mapper类

