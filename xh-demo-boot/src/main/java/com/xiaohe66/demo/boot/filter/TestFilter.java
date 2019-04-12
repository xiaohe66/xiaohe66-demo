package com.xiaohe66.demo.boot.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * @author xiaohe
 * @date 2019.04.12 11:38
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("xiaohe:TestFilter:init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("xiaohe:TestFilter:doFilter()");
    }

    @Override
    public void destroy() {
        System.out.println("xiaohe:TestFilter:destroy()");
    }
}
