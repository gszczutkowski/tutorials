package com.testcraftsmanship.resourcesmanagement.resources;

import com.testcraftsmanship.resourcesmanagement.resources.items.CognitoUser;

public interface TestDataCreator {

    default CognitoUser createTestPreconditions() {
        CognitoUser user = setUpPredefinedUser();
        //Other logic which set ups test data with use of user
        return user;
    }

    CognitoUser setUpPredefinedUser();
}
