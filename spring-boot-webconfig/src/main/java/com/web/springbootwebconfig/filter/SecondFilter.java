package com.web.springbootwebconfig.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: GWL
 * @Description: SpringBoot整合Filter 方式二
 * @Date: Create in 16:25 2019/5/17
 *
 */
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("进入SecondFilter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开SecondFilter");
    }
}
