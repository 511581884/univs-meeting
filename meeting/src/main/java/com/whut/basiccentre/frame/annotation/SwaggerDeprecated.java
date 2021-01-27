package com.whut.basiccentre.frame.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ysw
 * @email 1461182123@qq.com
 * @date 2020/9/17 11:45 上午
 * @description 过时的接口标记
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SwaggerDeprecated {
}
