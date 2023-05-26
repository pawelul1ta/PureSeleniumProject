package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends AbstractPage {
    @FindBy(css = "div[onClick *= 'handleLoginIssue']")
    private WebElement loginAndPasswordIssueCard;

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    public LoginAndPasswordIssuePage clickOnLoginAndPasswordIssueCard() {
        click(loginAndPasswordIssueCard);
        return new LoginAndPasswordIssuePage(driver);
    }
}
