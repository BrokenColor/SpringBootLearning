package com.web.springbootwebconfig.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: GWL
 * @Description: SpringBoot整合Servlet方式一 通过注解扫描完成Servlet组件的注册
 * @Date: Create in 14:56 2019/5/16
 *
 *<servlet>
 *	<servlet-name>FirstServlet</servlet-name>
 *	<servlet-class>com.bjsxt.servlet.FirstServlet</servlet-class>
 *</servlet>
 *
 *<servlet-mapping>
 * <servlet-name>FirstServlet</servlet-name>
 * <url-pattern>/first</url-pattern>
 *</servlet-mapping>
 *
 */

@WebServlet(name = "FirstServlet",urlPatterns = "/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("getServletName: "+this.getServletName());
        System.out.println("getServerInfo: "+this.getServletContext().getServerInfo());
        System.out.println("getVirtualServerName: "+this.getServletContext().getVirtualServerName());
        System.out.println("getContextPath: "+this.getServletContext().getContextPath());
        System.out.println("getRequestCharacterEncoding: "+this.getServletContext().getRequestCharacterEncoding());
        System.out.println("getServletContextName: "+this.getServletContext().getServletContextName());
        System.out.println("getServletContext: "+this.getServletContext());
        System.out.println("getServletInfo: "+this.getServletInfo());
        System.out.println("getServletConfig: "+this.getServletConfig());
        System.out.println("=========================");
        System.out.println("req.getContextPath:"+req.getContextPath());
        System.out.println("req.getMethod:"+req.getMethod());
        System.out.println("req.getPathInfo:"+req.getPathInfo());
        System.out.println("req.getRemoteUser:"+req.getRemoteUser());
        System.out.println("req.getRequestedSessionId:"+req.getRequestedSessionId());
        System.out.println("req.getRequestURI:"+req.getRequestURI());
        System.out.println("req.getServletPath:"+req.getServletPath());
        System.out.println("req.getCharacterEncoding:"+req.getCharacterEncoding());
        System.out.println("req.getLocalAddr:"+req.getLocalAddr());
        System.out.println("req.getLocalName:"+req.getLocalName());
        System.out.println("req.getProtocol:"+req.getProtocol());
        System.out.println("req.getRemoteAddr:"+req.getRemoteAddr());
        System.out.println("req.getRemoteHost:"+req.getRemoteHost());
        System.out.println("req.getAuthType:"+req.getAuthType());
        System.out.println("req.getRemotePort:"+req.getRemotePort());
        System.out.println("req.getScheme:"+req.getScheme());
        System.out.println("req.getServerPort:"+req.getServerPort());
        System.out.println("req.getCookies:"+req.getCookies());
    }
}
