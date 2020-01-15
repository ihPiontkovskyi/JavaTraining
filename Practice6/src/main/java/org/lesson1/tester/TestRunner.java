package org.lesson1.tester;

import org.lesson1.tester.annotation.After;
import org.lesson1.tester.annotation.AfterAll;
import org.lesson1.tester.annotation.Before;
import org.lesson1.tester.annotation.BeforeAll;
import org.lesson1.tester.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public void run(Class<?> clazz) throws Exception {
        final Constructor<?> constructors = clazz.getDeclaredConstructor();
        Object object = constructors.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> testMethods = getMethodByAnnotation(Test.class, methods);
        List<Method> beforeMethods = getMethodByAnnotation(Before.class, methods);
        List<Method> afterMethods = getMethodByAnnotation(After.class, methods);
        List<Method> afterAllMethods = getMethodByAnnotation(AfterAll.class, methods);
        List<Method> beforeAllMethods = getMethodByAnnotation(BeforeAll.class, methods);
        for (Method methodBeforeAll : beforeAllMethods) {
            methodBeforeAll.invoke(object);
        }
        for (Method testMethod : testMethods) {
            for (Method beforeMethod : beforeMethods) {
                beforeMethod.invoke(object);
            }
            testHandler(object, testMethod);
            for (Method afterMethod : afterMethods) {
                afterMethod.invoke(object);
            }
        }
        for (Method methodAfterAll : afterAllMethods) {
            methodAfterAll.invoke(object);
        }
    }

    private void testHandler(Object object, Method testMethod)
            throws IllegalAccessException, InvocationTargetException {
        Class<? extends Throwable> expectedEx = testMethod.getAnnotation(Test.class).expected();
        String expectedMs = testMethod.getAnnotation(Test.class).expectedMessage();
        if (expectedEx.equals(Test.None.class)) {
            testMethod.invoke(object);
        } else {
            if (expectedMs.equals(Test.EMPTY_STRING)) {
                try {
                    testMethod.invoke(object);
                    System.err.printf("Test %s failed: no exception%n", testMethod);
                } catch (Throwable e) {
                    if (!e.getCause().getClass().equals(expectedEx)) {
                        System.err.printf("Test %s failed: wrong exception was thrown%n", testMethod);
                    }
                }
            } else {
                try {
                    testMethod.invoke(object);
                    System.err.printf("Test %s failed: no exception%n", testMethod);
                } catch (Throwable e) {
                    if (!e.getCause().getClass().equals(expectedEx)) {
                        System.err.printf("Test %s failed: wrong exception was thrown%n", testMethod);
                    } else {
                        if (e.getCause().getMessage() != null && !e.getCause().getMessage().equals(expectedMs)) {
                            System.err.printf("Test %s failed: expected message: %s, actual: %s %n", testMethod, expectedMs, e.getMessage());
                        }
                    }
                }
            }
        }
    }

    private List<Method> getMethodByAnnotation(Class<? extends Annotation> clazz, Method[] methods) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(clazz)) {
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}
