package com.tachitomo.eduproj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.tachitomo.eduproj.repository")
public class EduprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduprojApplication.class, args);
	}

}
