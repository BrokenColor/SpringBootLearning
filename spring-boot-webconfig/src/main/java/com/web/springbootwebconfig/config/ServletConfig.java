package com.web.springbootwebconfig.config;

import com.web.springbootwebconfig.servlet.SecondServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: GWL
 * @Description: servlet配置类
 * @Date: Create in 14:50 2019/5/17
 */
@Configuration
public class ServletConfig {
    /**
     * SpringBoot整合Servlet方式二
     * 通过方法完成Servlet组件的注册
     * @return
     */
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new SecondServlet());
        servletRegistrationBean.addUrlMappings("/second");
        return servletRegistrationBean;
    }
}
