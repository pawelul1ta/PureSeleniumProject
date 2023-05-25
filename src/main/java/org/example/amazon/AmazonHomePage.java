package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonHomePage extends AbstractPage {
    @FindBy(css = "input[type='text']")
    private WebElement searchInput;

    @FindBy(css = "input[value='Go']")
    private WebElement searchButton;

    @FindBy(css = "div[class*='new_cust'] a")
    private WebElement newCustomerLink;

    @FindBy(css = "a[data-nav-role='signin']")
    private WebElement helloSignInElement;

    @FindBy(xpath = "//a[text()='Help']")
    private WebElement helpButton;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void typeSearchCriteria(String criteria) {
        writeText(searchInput, criteria);
    }

    public SearchResultsPage getSearchResults() {
        click(searchButton);
        return new SearchResultsPage(driver);
    }

    public CreateAccountPage clickOnNewCustomerLink() {
        String path = "div[class*='nav_pop_new'] a";

        hoverMouseOver(helloSignInElement);
        WebElement el = driver.findElement(By.cssSelector(path));
        wait.until(ExpectedConditions.visibilityOf(el));

        Actions actions = new Actions(driver);
        actions.moveToElement(el).click().build().perform();

        return new CreateAccountPage(driver);
    }

    public void scrollDownTheHomePage() {
        scrollDownThePage();
    }

    public HelpPage clickHelpButton() {
        wait.until(ExpectedConditions.visibilityOf(helpButton));
        click(helpButton);
        return new HelpPage(driver);
    }
}
