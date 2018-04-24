package com.fly.concurrency;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.fly.concurrency.example.threadLocal.RequestHolder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
                                                                                      ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        log.info("do filter, 线程id{}, 当前请求{}", Thread.currentThread().getId(), request.getServletPath());
        RequestHolder.add(Thread.currentThread().getId());
        arg2.doFilter(arg0, arg1);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
