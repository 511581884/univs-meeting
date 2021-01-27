package com.whut.basiccentre.frame.interceptor;

import com.whut.basiccentre.frame.annotation.LoginValid;
import com.whut.basiccentre.frame.bean.ResponseType;
import com.whut.basiccentre.frame.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import com.whut.basiccentre.frame.utils.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sandwich on 2018-08-13
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在请求被处理之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        LoginValid methodLoginValid = handlerMethod.getMethodAnnotation(LoginValid.class);
        // 1. 如果方法体上有 LoginValid
        if (methodLoginValid != null) {
            // 则判断是否需要登陆校验
            return !methodLoginValid.needLogin() || loginValid(request, response);
        }
        // 2. 如果方法体上没有注解 LoginValid, 则判断该方法的类上有没有这个注解 AppLoginValid
        LoginValid classLoginValid = handlerMethod.getBeanType().getAnnotation(LoginValid.class);
        if (classLoginValid != null) {
            // 如果有判断时候需要登陆校验
            return !classLoginValid.needLogin() || loginValid(request, response);
        }
        if (methodLoginValid == null && classLoginValid == null) {
            return true;
        }
        return loginValid(request, response);
    }

    private boolean loginValid(HttpServletRequest request, HttpServletResponse response) {

        return true;
    }

    /**
     * 在请求被处理后，视图渲染之前调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束后调用
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
