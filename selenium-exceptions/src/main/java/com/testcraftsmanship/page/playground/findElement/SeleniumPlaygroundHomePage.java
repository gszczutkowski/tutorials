package com.testcraftsmanship.page.playground.findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.testcraftsmanship.model.base.DriverFactory.getDriver;

public class SeleniumPlaygroundHomePage {

    public WebElement getLikeButton() {
        return findElement(By.id("number-of-likes"));
    }

    public String alertText() {
        return findElement(By.id("success-alert")).getText();
    }

    public String headingTimerValue() {
        return findElement(By.id("page-heading-timer")).getText();
    }

    public SeleniumPlaygroundHomePage clickLicenseConditionsButton() {
        findElement(By.id("open-modal-window-btn")).click();
        return this;
    }

    public SeleniumPlaygroundHomePage clickCloseButton() {
        findElement(By.id("close-btn")).click();
        return this;
    }

    public SeleniumPlaygroundHomePage clickShowAlertButton() {
        findElement(By.id("navbar-item-actions")).click();
        findElement(By.id("navbar-item-action-wait-for-alert")).click();
        return this;
    }

    private WebElement findElement(By by) {
        return getDriver().findElement(by);
    }
}
