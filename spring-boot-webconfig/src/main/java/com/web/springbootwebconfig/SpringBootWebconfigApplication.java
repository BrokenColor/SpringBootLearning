package com.web.springbootwebconfig;

import com.web.springbootwebconfig.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;

@SpringBootApplication
@ServletComponentScan  //在springBoot启动时会扫描@WebServlet，并将该类实例化
public class SpringBootWebconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebconfigApplication.class, args);
	}


}
