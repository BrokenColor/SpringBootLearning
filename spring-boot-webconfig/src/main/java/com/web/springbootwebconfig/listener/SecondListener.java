package com.web.springbootwebconfig.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author: GWL
 * @Description: SpringBoot整合Listener方式二
 * 通过方法完成Listener组件注册
 * @Date: Create in 16:44 2019/5/17
 */
public class SecondListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SecondListener init..");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
