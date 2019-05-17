package com.web.springbootwebconfig.config;

import com.web.springbootwebconfig.listener.SecondListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: GWL
 * @Description: Listener配置类
 * @Date: Create in 16:57 2019/5/17
 */
@Configuration
public class ListenerConfig {
    /**
     * SpringBoot整合Listener方式二
     *通过方法完成Listener组件注册
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean getServletListenerRegistrationBean() {
        ServletListenerRegistrationBean RegistrationBean = new ServletListenerRegistrationBean(new SecondListener());
        return RegistrationBean;
    }
}
