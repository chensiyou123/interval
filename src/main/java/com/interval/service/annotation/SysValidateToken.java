package com.interval.service.annotation;

import java.lang.annotation.*;

/**
 * 验证Token注解
 * @author nlife
 * @email xiamisspan@163.com
 * @date 2018/7/6 14:10
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysValidateToken {
    String value() default "";

    boolean flag() default true;
}
