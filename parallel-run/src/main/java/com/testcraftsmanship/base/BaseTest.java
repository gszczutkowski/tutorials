package com.testcraftsmanship.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest extends DriverProvider {
     private WebDriver driver;


     public<T extends BasePage> T openPage(Class<T> tClass) {
          return PageFactory.initElements(driver, tClass);
     }

}
