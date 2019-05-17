package com.web.springbootwebconfig.config;

import com.web.springbootwebconfig.filter.FirstFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: GWL
 * @Description: Filter配置类
 * @Date: Create in 16:34 2019/5/17
 */
@Configuration
public class FilterConfig {

    /**
     * SpringBoot整合Filter 方式二
     * 通过方法完成Filter组件的注册
     * @return
     */

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new FirstFilter());
        //bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
        filterRegistrationBean.addUrlPatterns("/second");
        return filterRegistrationBean;
    }
}
