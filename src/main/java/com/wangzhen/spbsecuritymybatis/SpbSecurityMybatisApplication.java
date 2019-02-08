package com.wangzhen.spbsecuritymybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描数据访问层接口的包名。
@MapperScan("com.wangzhen.spbsecuritymybatis.mapper")
public class SpbSecurityMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpbSecurityMybatisApplication.class, args);
	}

}

