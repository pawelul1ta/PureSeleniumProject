package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class SearchResultsPage extends AbstractPage {
    @FindBy(css = "div[class*='SEARCH_RESULTS'] a")
    private List<WebElement> foundItems;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        ;
    }

    public int count() {
        return foundItems.size();
    }

    public ProductPage clickOnFirstFoundItem() {
        if (count() > 0) {
            click(foundItems.get(0));
        } else {
            throw new NoSuchElementException("No items were found");
        }
        return new ProductPage(driver);
    }


}
