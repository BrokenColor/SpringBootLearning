package com.web.springbootwebconfig.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author: GWL
 * @Description: SpringBoot整合Listener方式一
 * 通过注解扫描完成Listener组件的注册
 * @Date: Create in 16:44 2019/5/17
 */
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("FirstListener init..");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
