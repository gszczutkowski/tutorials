package com.testcraftsmanship.clientsidecert.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {
    @FindBy(id = "footer")
    private WebElement authenticationInfo;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public String getAuthenticationInfo() {
        return authenticationInfo.getText();
    }
}