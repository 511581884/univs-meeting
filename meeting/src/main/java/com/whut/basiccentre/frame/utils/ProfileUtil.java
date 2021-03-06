package com.whut.basiccentre.frame.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ProfileUtil implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
    }

    /**
     * 获取当前环境参数  exp: dev,prod,test
     */
    public static String getActiveProfile() {
        String[] profiles = context.getEnvironment().getActiveProfiles();
        if (!StringUtil.isBlanks(profiles)) {
            return profiles[0];
        }
        return "";
    }
}
