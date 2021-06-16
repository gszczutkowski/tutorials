package com.testcraftsmanship;

import com.testcraftsmanship.model.base.BaseTest;
import com.testcraftsmanship.page.playground.pageObjectWait.SeleniumPlaygroundHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPlaygroundActionsWithWaitTest extends BaseTest {
    private SeleniumPlaygroundHomePage homePage;

    @Before
    public void setUp() {
        openApplication();
        homePage = PageFactory.initElements(getDriver(), SeleniumPlaygroundHomePage.class);
    }

    //StaleElementReferenceException - fixed
    @Test
    public void fixedGettingValueOfElementConstantlyChanging() {
        for (int i = 0; i < 1000; i++) {
            homePage.headingTimerValue();
        }
    }

    //ElementNotInteractableException - fixed
    @Test
    public void fixedInteractionWithElementNotVisibleYet() {
        for (int i = 0; i < 10; i++) {
            homePage.clickLicenseConditionsButton()
                    .clickCloseButton();
        }
    }

    //NoSuchElementException - fixed
    @Test
    public void fixedInteractingWithElementNotAvailableInDomTree() {
        homePage.clickShowAlertButton()
                .getAlertText();
    }
}
