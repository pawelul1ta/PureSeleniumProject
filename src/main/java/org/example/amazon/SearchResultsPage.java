package org.example.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {

    WebDriver driver;

    @FindBy(css = "div[class*='SEARCH_RESULTS']")
    List<WebElement> foundItems;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int count() {
        return foundItems.size();
    }
}
