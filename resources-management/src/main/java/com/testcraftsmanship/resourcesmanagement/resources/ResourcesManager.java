package com.testcraftsmanship.resourcesmanagement.resources;

import com.testcraftsmanship.resourcesmanagement.exceptions.ResourceNotAvailableException;
import com.testcraftsmanship.resourcesmanagement.resources.items.CognitoUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ResourcesManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourcesManager.class);
    private Set<CognitoUser> availableCognitoUsers;
    private static ResourcesManager instance;
    private static final int USER_AVAILABILITY_TIMEOUT_IN_SECONDS = 30;
    private static final int USER_AVAILABILITY_POOLING_IN_SECONDS = 1;
    private static final int MILLISECONDS_IN_SECOND = 1000;
    public static final Set<CognitoUser> COGNITO_USERS = Set.of(
            new CognitoUser("Khouthoum", "Dragondigger"),
            new CognitoUser("Grusgrul", "Duskshield"),
            new CognitoUser("Kheznaelynn", "Heavyfury"),
            new CognitoUser("Falael", "Wranvaris"),
            new CognitoUser("Kellam", "Ergwyn")
    );

    private ResourcesManager() {
        this.availableCognitoUsers = new HashSet<>(COGNITO_USERS);
    }

    public static ResourcesManager getResourcesManager() {
        if (instance == null) {
            instance = new ResourcesManager();
        }
        return instance;
    }

    public CognitoUser reserveUser() {
        final long timeout = new Date().getTime() + USER_AVAILABILITY_TIMEOUT_IN_SECONDS * MILLISECONDS_IN_SECOND;
        while (timeout > new Date().getTime()) {
            Optional<CognitoUser> availableUser = getFirstAvailableUser();
            if (availableUser.isPresent()) {
                return availableUser.get();
            }
            wait(USER_AVAILABILITY_POOLING_IN_SECONDS);
        }
        throw new ResourceNotAvailableException("There is no available user to get");
    }

    public synchronized void releaseUsers(Collection<CognitoUser> users) {
        for (CognitoUser user : users) {
            if (COGNITO_USERS.contains(user)) {
                availableCognitoUsers.add(user);
            } else {
                LOGGER.warn("Unable to release user {}", user);
            }
            LOGGER.info("Released user: {}", user);
        }
    }

    private synchronized Optional<CognitoUser> getFirstAvailableUser() {
        if (availableCognitoUsers.isEmpty()) {
            return Optional.empty();
        }
        CognitoUser user = availableCognitoUsers.iterator().next();
        availableCognitoUsers.remove(user);
        LOGGER.info("Reserved user: {}", user);
        return Optional.of(user);
    }

    private void wait(int seconds) {
        try {
            Thread.sleep(seconds * MILLISECONDS_IN_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
