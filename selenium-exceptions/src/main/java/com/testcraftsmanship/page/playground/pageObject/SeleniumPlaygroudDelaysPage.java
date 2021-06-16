package com.testcraftsmanship.page.playground.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

import static com.testcraftsmanship.model.base.DriverFactory.getDriver;

public class SeleniumPlaygroudDelaysPage {
    @FindBy(id = "progress-bar")
    private WebElement progressBar;

    @FindBy(id = "search-names-input")
    private WebElement searchInput;

    @FindBy(css = "table.filtered-table tbody tr")
    private List<WebElement> visitorsList;

    public SeleniumPlaygroudDelaysPage waitForPageToBeReady() {
        new WebDriverWait(getDriver(), 2)
                .until(ExpectedConditions.invisibilityOf(progressBar));
        return this;
    }

    public SeleniumPlaygroudDelaysPage searchByName(String name) {
        searchInput.sendKeys(name);
        return this;
    }

    public List<WebElement> getVisitorsList() {
        return visitorsList;
    }

    /**
     * Method search for item in the table and wait for only one element in the table.
     * This method is also NOT valid because all element are available even if only one is visible
     * @param name of item to be searched
     * @return page
     */
    public SeleniumPlaygroudDelaysPage searchByNameAndWaitForOne(String name) {
        searchInput.sendKeys(name);
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions
                        .numberOfElementsToBe(By.cssSelector("table.filtered-table tbody tr"),1));
        return this;
    }

    /**
     * Method search for item in the table and wait for only one element in the table.
     * This method is valid because counting only visible elements
     * @param name of item to be searched
     * @return page
     */
    public SeleniumPlaygroudDelaysPage searchByNameAndWaitForOneVisible(String name) {
        searchInput.sendKeys(name);
        new WebDriverWait(getDriver(), 10)
                .until(isOnlyOneVisible());
        return this;
    }

    private Function<WebDriver, Boolean> isOnlyOneVisible() {
        return driver -> visitorsList.stream().filter(element -> element.isDisplayed()).count() == 1;
    }

}
