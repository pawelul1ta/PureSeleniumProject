package org.example.amazon.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchResultsPageBase extends AbstractPage {
    protected SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int count();

    public abstract ProductPageBase clickOnFirstFoundItem();
}
