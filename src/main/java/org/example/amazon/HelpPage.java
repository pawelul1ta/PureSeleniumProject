package org.example.amazon;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends AbstractPage {
    @FindBy(css = "div[onClick *= 'handleLoginIssue']")
    private ExtendedWebElement loginAndPasswordIssueCard;

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    public LoginAndPasswordIssuePage clickOnLoginAndPasswordIssueCard() {
        loginAndPasswordIssueCard.click();
        return new LoginAndPasswordIssuePage(driver);
    }
}
