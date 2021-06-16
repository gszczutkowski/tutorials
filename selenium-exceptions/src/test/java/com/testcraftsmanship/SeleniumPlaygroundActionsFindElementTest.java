package com.testcraftsmanship;

import com.testcraftsmanship.model.base.BaseTest;
import com.testcraftsmanship.page.playground.findElement.SeleniumPlaygroundHomePage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SeleniumPlaygroundActionsFindElementTest extends BaseTest {
    private SeleniumPlaygroundHomePage homePage;

    @Before
    public void setUp() {
        openApplication();
        homePage = new SeleniumPlaygroundHomePage();
    }

    @Test
    public void gettingValueOfElementConstantlyChanging() {
        for (int i = 0; i < 1000; i++) {
            homePage.headingTimerValue();   //StaleElementReferenceException
        }
    }

    @Test
    public void gettingValueFromElementChangedByTheTest() {
        WebElement likeButton = homePage.getLikeButton();
        likeButton.click();
        likeButton.getText();   //StaleElementReferenceException

    }

    @Test
    public void fixedGettingValueFromElementChangedByTheTest() {
        homePage.getLikeButton().click();
        homePage.getLikeButton().getText();     //Getting the element once again to have updated version

    }

    @Test
    public void interactionWithElementNotVisibleYet() {
        for (int i = 0; i < 10; i++) {
            homePage.clickLicenseConditionsButton()
                    .clickCloseButton();    //ElementNotInteractableException
        }
    }

    @Test
    public void interactingWithElementNotAvailableInDomTree(){
        homePage.clickShowAlertButton()
                .alertText();       //NoSuchElementException
    }
}
