package com.graphometrica.rosatom_2021_backend.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!response.getHeaderNames().contains("Access-Control-Allow-Origin")) {
            response.addHeader("Access-Control-Allow-Origin", "*");
        }
        if(!response.getHeaderNames().contains("Access-Control-Allow-Methods")) {
            response.addHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
        }
        if(!response.getHeaderNames().contains("Access-Control-Allow-Headers")) {
            response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Accept, Authorization, Content-Type, Access-Control-Allow-Headers, Access-Control-Request-Method, Content-length, Access-Control-Allow-Origin, Subject, PartnerSubject");
        }
        return true;
    }
}
