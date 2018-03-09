package com.test.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
}
