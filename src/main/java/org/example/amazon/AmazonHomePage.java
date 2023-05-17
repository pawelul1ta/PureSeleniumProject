package org.example.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
    WebDriver driver;

    @FindBy(css = "input[type='text']")
    WebElement input;

    @FindBy(css = "input[value='Go']")
    WebElement searchButton;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeSearchCriteria(String criteria) {
        input.sendKeys(criteria);
    }

    public SearchResultsPage getSearchResults() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
