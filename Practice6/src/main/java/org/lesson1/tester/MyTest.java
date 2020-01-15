package org.lesson1.tester;

import org.lesson1.tester.annotation.After;
import org.lesson1.tester.annotation.AfterAll;
import org.lesson1.tester.annotation.Before;
import org.lesson1.tester.annotation.BeforeAll;
import org.lesson1.tester.annotation.Test;

public class MyTest {

    @BeforeAll
    public void beforeAll1() {
        System.out.println("before all");
    }

    @AfterAll
    public void afterAll1() {
        System.out.println("after all");
    }

    @Before
    public void before1() {
        System.out.print("before ");
    }

    @After
    public void after1() {
        System.out.println(" after");
    }

    @Test
    public void test1() {
        System.out.print("test1");
    }

    @Test(expected = NullPointerException.class)
    public void testThrow1() {
        System.out.print("null pointer");
        throw new NullPointerException();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow2() {
        System.out.print("Illegal argument but thrown null");
        throw new NullPointerException();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow3() {
        System.out.print("Illegal argument but nothing thrown");
    }

    @Test(expected = IllegalArgumentException.class, expectedMessage = "No argument")
    public void testThrow4() {
        System.out.print("Illegal argument with thrown correct message");
        throw new IllegalArgumentException("No argument");
    }

    @Test(expected = NullPointerException.class, expectedMessage = "Not Null")
    public void testThrow5() {
        System.out.print("Null pointer with thrown incorrect message");
        throw new NullPointerException("Null");
    }

    @Test
    public void test2() {
        System.out.print("test2");
    }

    private void notTest() {
        System.out.print("not test");
    }
}
