package com.testcraftsmanship.resourcesmanagement;

import com.testcraftsmanship.resourcesmanagement.resources.ResourcesManager;
import com.testcraftsmanship.resourcesmanagement.resources.TestDataCreator;
import com.testcraftsmanship.resourcesmanagement.resources.items.CognitoUser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;

import java.util.*;

public class BaseTest implements TestDataCreator {
    private static final String REMAINING_USERS_KEY = "testNameNotAccessible";
    private static final String CLASS_NAME_FOLLOWING_TEST_NAME_IN_STACK_TRACE = "jdk.internal.reflect.NativeMethodAccessorImpl";
    private static Map<String, List<CognitoUser>> usersUsedInTestCase = new HashMap<>();

    @AfterEach
    public void cleanUp(TestInfo testInfo){
        if (testInfo.getTestMethod().isPresent()) {
            final String testMethodName = testInfo.getTestMethod().get().getName();
            cleanUpUsersCreatedWhileTestCase(testMethodName);
        }
    }

    @AfterAll
    public static void cleanUp() {
        cleanUpUsersCreatedWhileTestCase(REMAINING_USERS_KEY);
    }

    public CognitoUser setUpPredefinedUser() {
        CognitoUser user = ResourcesManager.getResourcesManager().reserveUser();
        final String testMethodName = extractTestMethodName();
        List<CognitoUser> usersPerTest;
        if (usersUsedInTestCase.containsKey(testMethodName)) {
            usersPerTest = usersUsedInTestCase.get(testMethodName);
        } else {
            usersPerTest = new ArrayList<>();
        }
        usersPerTest.add(user);
        usersUsedInTestCase.put(testMethodName, usersPerTest);
        return user;
    }

    private static void cleanUpUsersCreatedWhileTestCase(String testMethodName) {
        if (usersUsedInTestCase.containsKey(testMethodName)) {
            ResourcesManager.getResourcesManager().releaseUsers(usersUsedInTestCase.get(testMethodName));
        }
    }

    private String extractTestMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElements.length; i++) {
            if (stackTraceElements[i].getClassName().equals(CLASS_NAME_FOLLOWING_TEST_NAME_IN_STACK_TRACE)) {
                return stackTraceElements[i - 1].getMethodName();
            }
        }
        return REMAINING_USERS_KEY;
    }
}
