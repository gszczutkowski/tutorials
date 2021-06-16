package com.testcraftsmanship.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends DriverProvider {
    private WebDriver driver;

    public<T extends BasePage> T openPage(Class<T> tClass) {
        T page = PageFactory.initElements(driver, tClass);
        page.setDriver(driver);
        return page;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
