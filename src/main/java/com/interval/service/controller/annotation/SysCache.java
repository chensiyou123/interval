package com.interval.service.controller.annotation;

import java.lang.annotation.*;

/**
 * 缓存注解
 * @author nlife
 * @email xiamisspan@163.com
 * @date 2018/8/3 10:11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysCache {
    /**
     * redis key 名称，若不填则生成规则为 类名_方法名_{extra}
     */
    String value() default "";

    /**
     * redis 失效时间，默认为一个小时
     */
    long expire() default 3600;

    /**
     * redis key 生成补充
     * example @SysCache(extra="model.id")
     *         public Object get(Model model)
     *example @SysCache(extra="pkid")
     * public Object get(int pkid)
     */
    String extra() default "";
}
