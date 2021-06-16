package com.testcraftsmanship;

import com.testcraftsmanship.model.base.BaseTest;
import com.testcraftsmanship.page.playground.pageObject.SeleniumPlaygroudDelaysPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

public class DelayedTableTest extends BaseTest {
    private SeleniumPlaygroudDelaysPage homePage;



    @Before
    public void setUp() {
        openApplicationInDelaysTab();
        homePage = PageFactory.initElements(getDriver(), SeleniumPlaygroudDelaysPage.class).waitForPageToBeReady();
    }

    @Test
    public void filteredUserShouldBeDisplayed() {
        int size = homePage.searchByName("Gert")
                .getVisitorsList()
                .size();
        assertThat(size, is(1));
    }

    //wait for visibility of only one not work
    @Test
    public void filteredUserShouldBeDisplayedAfterSomeTime() {
        int size = homePage.searchByNameAndWaitForOne("Gert")
                .getVisitorsList()
                .size();
        assertThat(size, is(1));
    }

    //wait for visibility of only one not work
    @Test
    public void filteredUserShouldBeDisplayedAfterSomeTimeUseDedicatedMethod() {
        long size = homePage.searchByNameAndWaitForOneVisible("Gert")
                .getVisitorsList()
                .stream().filter(element -> element.isDisplayed()).count();
        assertThat(size, is(1L));
    }
}
