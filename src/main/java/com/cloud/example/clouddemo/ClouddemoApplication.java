package com.cloud.example.clouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//@EnableEurekaServer
@SpringBootApplication
@MapperScan(basePackages = "com.cloud.example.clouddemo.*.dao")
//@EnableFeignClients
public class ClouddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClouddemoApplication.class, args);
	}

}
