package com.example.catdemo.utils;

import java.lang.annotation.*;

/**
 * 打印方法入参和出参的注解
 * @author jennyzhuzhu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "";

}
