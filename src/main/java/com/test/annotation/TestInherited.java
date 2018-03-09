package com.test.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Inherited是继承的意思，但并不是注解本身可以集成，
 * 而是说明一个超类被@Inherited注解过的注释进行注解的的话，那么它的自雷没有被任何注解应用的话，
 * 那么这个子类就继承了超类的注解
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface TestInherited {
}

@TestInherited
class A {
}

class B extends A {}


