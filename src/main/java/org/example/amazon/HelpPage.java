package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HelpPage extends AbstractPage {
    @FindBy(css = "div[onClick *= 'handleLoginIssue']")
    private WebElement loginAndPasswordIssueCard;

    public HelpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginAndPasswordIssuePage clickOnLoginAndPasswordIssueCard() {
        String path = "div[onClick *= 'handleLoginIssue']";
        click(driver.findElement(By.cssSelector(path)));
        return new LoginAndPasswordIssuePage(driver);
    }
}
