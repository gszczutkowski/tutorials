package com.testcraftsmanship.allure.integration.model;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.testcraftsmanship.allure.integration.config.Config.config;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@Epic("TCE-001: Support search engine")
public class GoogleSearchTest {
    private static final String GOOGLE_URL = "https://google.com";

    @BeforeClass
    public static void setUp() {
        config().initializeAllureSettings();
    }

    @TmsLink("TestCase-001")
    @Story("TCS-003: Support searching by text criteria.")
    @DisplayName("Search engine should work with long search criteria")
    @Test
    public void searchForLongCriteriaShouldMatchResults() {
        GooglePage resultsPage = openPage()
                .clickOnInputField()
                .enterTextInSearchField("Very long searching criteria")
                .clickOnSearchButton();

        assertThat(resultsPage.firstItemTitle()).isEqualTo("");
    }

    @TmsLink("TestCase-002")
    @Story("TCS-003: Support searching by text criteria.")
    @DisplayName("Search should not be possible when there is no search criteria")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void searchShouldNotBePerformedWhenNoCriteria() {
        GooglePage resultsPage = openPage(GOOGLE_URL)
                .clickOnInputField()
                .enterTextInSearchField("")
                .clickOnSearchButton();

        assertThat(resultsPage.firstItemTitle()).isEqualTo("");
    }

    @TmsLink("TestCase-002")
    @Story("TCS-003: Support searching by text criteria.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void itShouldBePossibleToSearchPhrase() {
        GooglePage resultsPage = openPage(GOOGLE_URL)
                .clickOnInputField()
                .enterTextInSearchField("Biggest country in the world")
                .clickOnSearchButton();

        assertThat(resultsPage.firstItemTitle()).isEqualTo("Russia");
    }

    @TmsLink("TestCase-003")
    @Issue("438")
    @Story("TCS-003: Support searching by text criteria.")
    @DisplayName("Search engine should work with single word")
    @Description("Search engine should return pages which contain in the title or content desired word."
            + " Order of the returned pages should be ascending by popularity.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void itShouldBePossibleToSearchSingleWord() {
        GooglePage resultsPage = openPage(GOOGLE_URL)
                .clickOnInputField()
                .enterTextInSearchField("Yacht")
                .clickOnSearchButton();

        assertThat(resultsPage.firstItemTitle()).isEqualTo("Christina O");
    }

    @Ignore("Automation test is not finished")
    @Stories({
            @Story("TCS-002: Create search engine for lucky searching"),
            @Story("TCS-004: Support searching lucky results.")
    })
    @Severity(SeverityLevel.MINOR)
    @Test
    public void iAmFeelingLuckyShouldBeBlockedForSecondClick() {
        GooglePage resultsPage = openPage(GOOGLE_URL)
                .clickOnInputField()
                .clickOnImFeelingLucky();

        assertThat(resultsPage.clickOnImFeelingLucky()).isEqualTo(resultsPage);
    }

    @Stories({
            @Story("TCS-002: Create search engine for lucky searching"),
            @Story("TCS-004: Support searching lucky results.")
    })
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void iAmFeelingLuckyShouldReturnDesiredResults() {

        GooglePage resultsPage = openPage(GOOGLE_URL)
                .clickOnInputField()
                .clickOnImFeelingLucky();

        assertThat(resultsPage.firstItemTitle()).isEqualTo("Christina O");
    }

    @After
    public void tearDown() throws IOException, URISyntaxException {
        savePngAttachment(takeScreenshot());
    }

    @Step("Open browser and navigate to {url}")
    private GooglePage openPage(String... url) {
        if (url[0].equals("https://google.com")) {
            return new GooglePage();
        } else {
            return null;
        }
    }

    @Attachment(value = "Screenshot from web page.", type = "image/png")
    public byte[] savePngAttachment(URL screenshotUrl) throws URISyntaxException, IOException {
        if (screenshotUrl == null) {
            fail("Couldn't find resource 'screenshot.png'");
        }
        return Files.readAllBytes(Paths.get(screenshotUrl.toURI()));
    }

    public URL takeScreenshot(){
        return getClass().getClassLoader().getResource("screenshot.png");
    }
}
