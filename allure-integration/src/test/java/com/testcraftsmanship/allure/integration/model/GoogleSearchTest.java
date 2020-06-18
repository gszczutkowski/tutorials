package com.testcraftsmanship.allure.integration.model;

import org.junit.After;
import org.junit.Test;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchTest {
    private static final String GOOGLE_URL = "https://google.com";

    @Test
    public void searchForLongCriteriaShouldMatchResults() {
        GooglePage resultsPage = openPage()
                .clickOnInputField()
                .enterTextInSearchField("Very long searching criteria")
                .clickOnSearchButton();

        assertThat(resultsPage.firstItemTitle()).isEqualTo("");
    }

    @Test
    public void searchShouldNotBePerformedWhenNoCriteria() {
        GooglePage resultsPage = openPage(GOOGLE_URL)
                .clickOnInputField()
                .enterTextInSearchField("")
                .clickOnSearchButton();

        assertThat(resultsPage.firstItemTitle()).isEqualTo("");
    }

    @Test
    public void itShouldBePossibleToSearchPhrase() {
        GooglePage resultsPage = openPage(GOOGLE_URL)
                .clickOnInputField()
                .enterTextInSearchField("Biggest country in the world")
                .clickOnSearchButton();

        assertThat(resultsPage.firstItemTitle()).isEqualTo("Russia");
    }

    @Test
    public void itShouldBePossibleToSearchSingleWord() {
        GooglePage resultsPage = openPage(GOOGLE_URL)
                .clickOnInputField()
                .enterTextInSearchField("Yacht")
                .clickOnSearchButton();

        assertThat(resultsPage.firstItemTitle()).isEqualTo("Christina O");
    }

    @Test
    public void iAmFeelingLuckyShouldBeBlockedForSecondClick() {
        GooglePage resultsPage = openPage(GOOGLE_URL)
                .clickOnInputField()
                .clickOnImFeelingLucky();

        assertThat(resultsPage.clickOnImFeelingLucky()).isEqualTo(resultsPage);
    }

    @Test
    public void iAmFeelingLuckyShouldReturnDesiredResults() {

        GooglePage resultsPage = openPage(GOOGLE_URL)
                .clickOnInputField()
                .clickOnImFeelingLucky();

        assertThat(resultsPage.firstItemTitle()).isEqualTo("Christina O");
    }

    @After
    public void tearDown() {
        takeScreenshot();
    }

    private GooglePage openPage(String... url) {
        if (url[0].equals("https://google.com")) {
            return new GooglePage();
        } else {
            return null;
        }
    }

    public URL takeScreenshot(){
        return getClass().getClassLoader().getResource("screenshot.png");
    }
}
