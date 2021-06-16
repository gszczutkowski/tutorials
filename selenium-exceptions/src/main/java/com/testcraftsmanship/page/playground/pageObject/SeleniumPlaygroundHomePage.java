package com.testcraftsmanship.page.playground.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumPlaygroundHomePage {

    @FindBy(id = "page-heading-timer")
    private WebElement pageHeadingTimer;

    @FindBy(id = "number-of-likes")
    private WebElement likeButton;

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
        return pageHeadingTimer.getText();
    }


    public SeleniumPlaygroundHomePage clickLicenseConditionsButton() {
        openModalWindowButton.click();
        return this;
    }

    public SeleniumPlaygroundHomePage clickCloseButton() {
        closeButton.click();
        return this;
    }


    public SeleniumPlaygroundHomePage clickShowAlertButton() {
        actionsMenu.click();
        showAlertMenuItem.click();
        return this;
    }

    public SeleniumPlaygroundHomePage clickLikeButton() {
        likeButton.click();
        return this;
    }

    public String numberOfLikes() {
        return likeButton.getText();
    }

    public String getAlertText() {
        return successAlert.getText();
    }
}
