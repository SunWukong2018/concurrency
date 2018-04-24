package com.fly.concurrency;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fly.concurrency.example.threadLocal.RequestHolder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpIntercepter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("preHandle , 线程id{}, 当前请求{}", Thread.currentThread().getId(), request.getRequestURL().toString());
        RequestHolder.add(Thread.currentThread().getId());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse,
                                Object obj, Exception exception) throws Exception {
        RequestHolder.remove();
        log.info("afterCompletion");
    }

}
