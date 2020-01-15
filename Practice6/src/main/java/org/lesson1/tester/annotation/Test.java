package org.lesson1.tester.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    String EMPTY_STRING = "";

    final class None extends Throwable {
        private None() {
        }
    }

    Class<? extends Throwable> expected() default None.class;

    String expectedMessage() default EMPTY_STRING;
}
