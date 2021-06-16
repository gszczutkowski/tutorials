package com.testcraftsmanship.model.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.graalvm.compiler.phases.BasePhase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    public void openApplication() {
        String seleniumPlaygroundPagePath = BaseTest.class
                .getResource("/selenium-playgroud-page/index.html").getPath();
        driver.get("file://" + seleniumPlaygroundPagePath);
    }

    public void openApplicationInDelaysTab() {
        String seleniumPlaygroundPagePath = BaseTest.class
                .getResource("/selenium-playgroud-page/delays.html").getPath();
        driver.get("file://" + seleniumPlaygroundPagePath);
    }


    public WebDriver getDriver() {
        return driver;
    }
}
