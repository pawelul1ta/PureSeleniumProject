package org.example.amazon.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AmazonHomePageBase extends AbstractPage {
    public AmazonHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeSearchCriteria(String criteria);

    public abstract SearchResultsPageBase getSearchResults();

    public abstract CreateAccountPageBase clickOnNewCustomerLink();

    public abstract HelpPageBase clickHelpButton();
}
