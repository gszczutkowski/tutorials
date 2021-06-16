package com.testcraftsmanship.page.playground.pageObjectWait;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.testcraftsmanship.model.base.DriverFactory.getDriver;

public class SeleniumPlaygroundHomePage {
    private static final int TIMEOUT_IN_SECONDS = 4;
    @FindBy(id = "page-heading-timer")
    private WebElement pageHeadingTimer;


    @FindBy(id = "open-modal-window-btn")
    private WebElement openModalWindowButton;

    @FindBy(id = "close-btn")
    private WebElement closeButton;


    @FindBy(id = "navbar-item-actions")
    private WebElement actionsMenu;

    @FindBy(id = "navbar-item-action-wait-for-alert")
    private WebElement showAlertMenuItem;

    @FindBy(id = "success-alert")
    private WebElement successAlert;


    public String headingTimerValue() {
        return getTextFromUpdatingElement(pageHeadingTimer);
    }

    private String getTextFromUpdatingElement(WebElement element) {
        try {
            return element.getText();
        } catch (StaleElementReferenceException e) {
            return element.getText();
        }
    }


    public SeleniumPlaygroundHomePage clickLicenseConditionsButton() {
        new WebDriverWait(getDriver(),TIMEOUT_IN_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(openModalWindowButton))
                .click();
        return this;
    }

    public SeleniumPlaygroundHomePage clickCloseButton() {
        new WebDriverWait(getDriver(),TIMEOUT_IN_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(closeButton))
                .click();

        new WebDriverWait(getDriver(),TIMEOUT_IN_SECONDS)
                .until(ExpectedConditions.invisibilityOf(closeButton));
        return this;
    }


    public SeleniumPlaygroundHomePage clickShowAlertButton() {
        actionsMenu.click();
        showAlertMenuItem.click();
        return this;
    }

    public String getAlertText() {
        return new WebDriverWait(getDriver(),TIMEOUT_IN_SECONDS)
                .until(ExpectedConditions.visibilityOf(successAlert))
                .getText();
    }
}
