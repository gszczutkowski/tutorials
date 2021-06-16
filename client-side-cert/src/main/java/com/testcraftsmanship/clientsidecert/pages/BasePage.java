package com.testcraftsmanship.clientsidecert.pages;


import com.testcraftsmanship.clientsidecert.base.PageInitializer;
import org.openqa.selenium.WebDriver;

public abstract class BasePage implements PageInitializer {
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}