package com.interval.service.controller.annotation;


import java.lang.annotation.*;

/**
 * 系统计时日志注解
 * @author nlife
 * @email xiamisspan@163.com
 * @date 2018/7/31 12:03
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysTimeLog {
    String value() default "";
}
