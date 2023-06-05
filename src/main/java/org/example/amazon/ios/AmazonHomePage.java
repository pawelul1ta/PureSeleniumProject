package org.example.amazon.ios;


import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.amazon.base.AmazonHomePageBase;
import org.example.amazon.base.CreateAccountPageBase;
import org.example.amazon.base.HelpPageBase;
import org.example.amazon.base.SearchResultsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AmazonHomePageBase.class)
public class AmazonHomePage extends AmazonHomePageBase {
    @FindBy(css = "input[type='text']")
    private ExtendedWebElement searchInput;

    @FindBy(css = "input[value='Go']")
    private ExtendedWebElement searchButton;

    @FindBy(css = "div[class ='nav-progressive-content'] a")
    private ExtendedWebElement helloSignInElement;

    @FindBy(css = "span[class='a-expander-prompt']")
    private ExtendedWebElement helpButton;

    @FindBy(id = "ap-other-signin-issues-link")
    private ExtendedWebElement otherSigninIssuesLink;

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
        helloSignInElement.click();
        return initPage(driver, CreateAccountPageBase.class);
    }

    @Override
    public HelpPageBase clickHelpButton() {
        helloSignInElement.click();
        helpButton.click();
        otherSigninIssuesLink.click();
        return initPage(driver, HelpPageBase.class);
    }
}
