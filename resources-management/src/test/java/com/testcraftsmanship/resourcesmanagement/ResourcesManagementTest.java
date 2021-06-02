package com.testcraftsmanship.resourcesmanagement;

import com.testcraftsmanship.resourcesmanagement.resources.items.CognitoUser;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ResourcesManagementTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourcesManagementTest.class);

    @Test
    public void test0() {
        CognitoUser user = createTestPreconditions();
        testLogicWhichUsesResources(user);
    }

    @Test
    public void test1() {
        CognitoUser user = createTestPreconditions();
        testLogicWhichUsesResources(user);
    }

    @Test
    public void test2() {
        CognitoUser user = createTestPreconditions();
        testLogicWhichUsesResources(user);
    }

    @Test
    public void test3() {
        CognitoUser user = createTestPreconditions();
        testLogicWhichUsesResources(user);
    }

    @Test
    public void test4() {
        CognitoUser user = createTestPreconditions();
        testLogicWhichUsesResources(user);
    }

    private void testLogicWhichUsesResources(CognitoUser user) {
        LOGGER.info("Running test with user :{}", user);
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
