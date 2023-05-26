package org.example.amazon;


import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends AbstractPage {
    @FindBy(css = "input[type='text']")
    private ExtendedWebElement searchInput;

    @FindBy(css = "input[value='Go']")
    private ExtendedWebElement searchButton;

    @FindBy(css = "div[class*='nav_pop_new'] a")
    private ExtendedWebElement newCustomerLink;

    @FindBy(css = "a[data-nav-role='signin']")
    private ExtendedWebElement helloSignInElement;

    @FindBy(xpath = "//a[text()='Help']")
    private ExtendedWebElement helpButton;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void typeSearchCriteria(String criteria) {
        searchInput.type(criteria);
    }

    public SearchResultsPage getSearchResults() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    public CreateAccountPage clickOnNewCustomerLink() {

        helloSignInElement.hover();
        newCustomerLink.hover();
        newCustomerLink.click();

        return new CreateAccountPage(driver);
    }

    public void scrollDownTheHomePage() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public HelpPage clickHelpButton() {
        helpButton.click();
        return new HelpPage(driver);
    }
}
