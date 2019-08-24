package com.interval.service.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class UserFilter implements Filter {
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/web/login/toLogin", "/web/login/login", "/web/login/logout")));
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 登陆过略器，如果匹配到过略路径则放行，否则判断HttpSession 中是否有用户类型，
     * @param request request
     * @param response response
     * @param chain chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        String path = servletRequest.getRequestURI().substring(servletRequest.getContextPath().length()).replaceAll("[/]+$", "");
       //不需要过略的路径
        boolean allowedPath = ALLOWED_PATHS.contains(path);
        if (allowedPath) {
            chain.doFilter(request, response);
            return;
        }
        Integer userType = (Integer)servletRequest.getSession().getAttribute("userType");
        if (userType == null){
            servletResponse.sendRedirect("/web/login/toLogin");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
