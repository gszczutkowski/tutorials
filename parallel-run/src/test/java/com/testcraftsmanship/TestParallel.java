package com.testcraftsmanship;

import com.testcraftsmanship.base.BasePage;
import com.testcraftsmanship.base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

public class TestParallel extends BaseTest {


    @Before
    public void setUp() {
         setThread(Thread.currentThread().getName() + UUID.randomUUID());
    }

    @After
    public void cleanUp() {
        setThread("");
    }

    @Test
    public void test1() {
        System.out.println(getThread() + " start");
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getThread() + " end");
    }

    @Test
    public void test2() {
        System.out.println(getThread() + " start");
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getThread() + " end");
    }

    @Test
    public void test3() {
        System.out.println(getThread() + " start");
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getThread() + " end");
    }

    @Test
    public void test4() {
        System.out.println(getThread() + " start");
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getThread() + " end");
    }

}
