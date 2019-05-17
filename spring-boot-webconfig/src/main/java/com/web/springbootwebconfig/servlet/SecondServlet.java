package com.web.springbootwebconfig.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: GWL
 * @Description: SpringBoot整合Servlet方式二 通过方法完成Servlet组件的注册
 * @Date: Create in 11:47 2019/5/17
 */
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("SpringBoot整合Servlet方式二: " + this.getServletName());
    }
}
