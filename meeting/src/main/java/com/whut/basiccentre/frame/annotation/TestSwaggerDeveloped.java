package com.whut.basiccentre.frame.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ysw
 * @email 1461182123@qq.com
 * @date 2020/9/17 11:45 上午
 * @description 用于生成接口文档，便于ysw熟悉项目，前端进行联调测试
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TestSwaggerDeveloped {
}
