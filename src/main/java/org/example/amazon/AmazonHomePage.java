package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends AbstractPage {

    @FindBy(css = "input[type='text']")
    WebElement input;

    @FindBy(css = "input[value='Go']")
    WebElement searchButton;

    @FindBy(css = "div[class*='new_cust'] a")
    WebElement newCustomerLink;

    @FindBy(id = "nav-link-accountList")
    WebElement helloSignInElement;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void typeSearchCriteria(String criteria) {
        writeText(input, criteria);
    }

    public SearchResultsPage getSearchResults() {
        click(searchButton);
        return new SearchResultsPage(driver);
    }

    public void hoverMouseOverHelloSignInElement() {
        hoverMouseOver(helloSignInElement);
    }

    public CreateAccountPage clickOnNewCustomerLink() {
        hoverMouseOver(helloSignInElement)
                .moveToElement(newCustomerLink)
                .click()
                .build()
                .perform();
        return new CreateAccountPage(driver);
    }
}
