package com.testcraftsmanship.clientsidecert.base;

import com.testcraftsmanship.clientsidecert.authentication.UserType;
import com.testcraftsmanship.clientsidecert.pages.AuthenticationPage;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest implements PageInitializer {
    private WebDriver driver;

    public BaseTest() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public AuthenticationPage openApplicationAs(UserType userType) {
        driver = DriverFactory.getDriver(userType);
        driver.get("`https://client.badssl.com/`");
        return newInstance(AuthenticationPage.class);
    }

    protected void closeApplication() {
        if (driver != null) {
            driver.quit();
        }
    }
}