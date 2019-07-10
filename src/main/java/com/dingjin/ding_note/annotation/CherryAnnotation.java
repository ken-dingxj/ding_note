package com.dingjin.ding_note.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface CherryAnnotation {
    public String name();
    int age()default 18;
    int[] score();
}

