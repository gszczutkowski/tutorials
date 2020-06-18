package com.testcraftsmanship.allure.integration.model;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GooglePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(GooglePage.class);
    private String searchCriteria = "";

    @Step("Click on google search field.")
    public GooglePage clickOnInputField() {
        LOGGER.info("Clicking on google search field.");
        return this;
    }

    @Step("Enter {text} in google search field.")
    public GooglePage enterTextInSearchField(String text) {
        LOGGER.info("Entering text '{}' in the google input field.", text);
        searchCriteria = text;
        return this;
    }

    @Step("Click [I'm feeling lucky] button.")
    public GooglePage clickOnImFeelingLucky() {
        LOGGER.info("Clicking on I'm feeling lucky button.");
        return this;
    }

    @Step("Click on [Search] button.")
    public GooglePage clickOnSearchButton() {
        LOGGER.info("Clicking on google search field.");
        return this;
    }

    public String firstItemTitle() {
        LOGGER.info("Clicking on google search field.");
        if (searchCriteria.equals("Biggest country in the world")) {
            return "Russia";
        } else {
            return "";
        }
    }
}
