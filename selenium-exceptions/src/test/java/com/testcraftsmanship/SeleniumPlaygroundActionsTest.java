package com.testcraftsmanship;

import com.testcraftsmanship.model.base.BaseTest;
import com.testcraftsmanship.page.playground.pageObject.SeleniumPlaygroundHomePage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPlaygroundActionsTest extends BaseTest {
    private SeleniumPlaygroundHomePage homePage;

    @Before
    public void setUp() {
        openApplication();
        homePage = PageFactory.initElements(getDriver(), SeleniumPlaygroundHomePage.class);
    }

    @Test
    public void gettingValueOfElementConstantlyChanging() {
        for (int i = 0; i < 1000; i++) {
            homePage.headingTimerValue();    //StaleElementReferenceException
        }
    }

    @Test
    public void fixedGettingValueFromElementChangedByTheTest() {
            homePage.clickLikeButton();
            homePage.numberOfLikes();     //Getting the element once again to have updated version
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
                .getAlertText();    //NoSuchElementException
    }
}
