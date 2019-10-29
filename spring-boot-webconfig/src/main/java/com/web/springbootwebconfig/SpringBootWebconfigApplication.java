package com.web.springbootwebconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)//去除spring默认的错误页面
@ServletComponentScan  //在springBoot启动时会扫描@WebServlet，并将该类实例化
public class SpringBootWebconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebconfigApplication.class, args);
	}


}
