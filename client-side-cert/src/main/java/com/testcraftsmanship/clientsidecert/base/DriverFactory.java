package com.testcraftsmanship.clientsidecert.base;


import com.testcraftsmanship.clientsidecert.authentication.UserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class DriverFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverFactory.class);
    private static WebDriver driver;
    private static DriverType driverType = DriverType.FIREFOX_DRIVER;

    enum DriverType {
        FIREFOX_DRIVER
    }
    private DriverFactory(){}

    public static WebDriver getDriver(UserType userType) {
        if (driver == null && driverType.equals(DriverType.FIREFOX_DRIVER)) {
            WebDriverManager.firefoxdriver().config();
            driver = new FirefoxDriver(createFirefoxDriverOptions(userType));
        }
        LOGGER.info("Return {}", driverType);
        return driver;
    }

    private static FirefoxOptions createFirefoxDriverOptions(UserType userType) {
        File firefoxProfileFile = new File(DriverFactory.class.getResource(userType.getProfilePath()).getPath());
        FirefoxProfile profile = new FirefoxProfile(firefoxProfileFile);
        profile.setPreference("security.default_personal_cert", "Select Automatically");
        profile.setPreference("intl.accept_languages", "en-gb");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return options;
    }
}