package com.mybatis.config;

import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * Druid监控配置
 * @author BrokenColor
 * @date 2018年6月13日
 */
@Configuration
public class DruidMonitorConfigurer {
	
	/**
	 * 注册ServletRegistrationBean
	 */
	@Bean
	public ServletRegistrationBean<Servlet> registrationBean(){
		ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<Servlet>(new StatViewServlet(), "/druid/*");
		//初始化参数配置
		//白名单
		bean.addInitParameter("allow", "127.0.0.1");
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
