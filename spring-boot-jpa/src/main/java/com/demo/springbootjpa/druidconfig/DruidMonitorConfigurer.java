package com.demo.springbootjpa.druidconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.sql.DataSource;

/**
 * Druid监控配置
 * @author gwl
 * @date 2019年5月20日
 */
@Configuration
public class DruidMonitorConfigurer {

	//将设置参数的druid的数据源注册到IOC容器中
//	@ConfigurationProperties(prefix = "spring.datasource")
//	@Bean
//	public DataSource druid() {
//		return new DruidDataSource();
//	}

	/**
	 * 注册ServletRegistrationBean
	 */
	@Bean
	public ServletRegistrationBean<Servlet> registrationBean(){
		ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<Servlet>(new StatViewServlet(), "/druid/*");
		//初始化参数配置
		//白名单
		bean.addInitParameter("allow", "127.0.0.1");
		bean.addInitParameter("allow", "192.168.6.3");
		//IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
		//bean.addInitParameter("deny", "192.168.1.110");
		//用户信息
		bean.addInitParameter("loginUsername", "admin");
		bean.addInitParameter("loginPassword", "password");
		//是否能够重置数据
		bean.addInitParameter("restEnable", "false");
		return bean;
	}
	/**
	 * 注册FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean<WebStatFilter> druidStatFilter(){
		FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<WebStatFilter>(new WebStatFilter());
		//添加过滤则
		bean.addUrlPatterns("/*");
		//添加不需要忽略的格式信息.
		bean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return bean;
	}
}
