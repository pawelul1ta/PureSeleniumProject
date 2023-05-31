package org.example.amazon.web;


import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.amazon.base.AmazonHomePageBase;
import org.example.amazon.base.CreateAccountPageBase;
import org.example.amazon.base.HelpPageBase;
import org.example.amazon.base.SearchResultsPageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AmazonHomePageBase.class)
public class AmazonHomePage extends AmazonHomePageBase {
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

    @Override
    public void typeSearchCriteria(String criteria) {
        searchInput.type(criteria);
    }

    @Override
    public SearchResultsPageBase getSearchResults() {
        searchButton.click();
        return initPage(driver, SearchResultsPageBase.class);
    }

    @Override
    public CreateAccountPageBase clickOnNewCustomerLink() {

        helloSignInElement.hover();
        newCustomerLink.hover();
        newCustomerLink.click();

        return initPage(driver, CreateAccountPageBase.class);
    }

    public void scrollDownTheHomePage() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    @Override
    public HelpPageBase clickHelpButton() {
        scrollDownTheHomePage();
        helpButton.click();
        return initPage(driver, HelpPageBase.class);
    }
}
