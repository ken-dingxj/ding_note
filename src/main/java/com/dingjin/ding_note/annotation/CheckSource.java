package com.dingjin.ding_note.annotation;

import java.lang.annotation.*;

/**
 * @author ding
 */
@Target(ElementType.METHOD)//该注解使用在方法上
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Documented
public @interface CheckSource {
    //该注解的参数,是一个string数组
    String[] sources() default {"all"};
}
