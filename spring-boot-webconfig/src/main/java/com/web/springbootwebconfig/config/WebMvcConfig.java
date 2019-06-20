package com.web.springbootwebconfig.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:跨域
 * <p>
 * Author: GWL
 * Date: Create in 16:59 2019/6/20
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     *全局配置一次性解决跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // /**表示本应用的所有方法都会去处理跨域请求
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
