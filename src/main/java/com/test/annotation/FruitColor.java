package com.test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 苹果颜色注解.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

  /**
   * 颜色枚举.
   */
  enum Color {BLUE, RED, GREEN};

  /**
   * 颜色属性.
   * @return
   */
  Color fruitColor() default Color.GREEN;
}
