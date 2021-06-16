package com.testcraftsmanship;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

public class LoggingTest {

    @Rule public MethodRule watchman = new TestWatcher() {
        public void starting(FrameworkMethod method) {
            System.out.println("being run..." + method.getName());
        }
    };

    final Logger logger =
            LoggerFactory.getLogger(LoggingTest.class);

    @Test
    public void testA() {

    }

    @Test
    public void testB() {

    }
}