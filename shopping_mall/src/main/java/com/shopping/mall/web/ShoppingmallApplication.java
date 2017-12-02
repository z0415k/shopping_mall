package com.shopping.mall.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zk
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableSwagger2
public class ShoppingmallApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShoppingmallApplication.class, args);
	}
}
