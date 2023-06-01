package org.example.amazon.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.amazon.base.AmazonHomePageBase;
import org.example.amazon.base.ProductPageBase;
import org.example.amazon.base.SearchResultsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {
    @FindBy(css = "div[class*='SEARCH_RESULTS'] a")
    private List<ExtendedWebElement> foundItems;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public int count() {
        return foundItems.size();
    }

    @Override
    public ProductPageBase clickOnFirstFoundItem() {
        if (count() > 0) {
            foundItems.get(0).click();
        } else {
            throw new NoSuchElementException("No items were found");
        }
        return initPage(driver, ProductPageBase.class);
    }

}
