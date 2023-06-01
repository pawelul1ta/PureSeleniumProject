package org.example.amazon.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.amazon.base.HelpPageBase;
import org.example.amazon.base.LoginAndPasswordIssuePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HelpPageBase.class)
public class HelpPage extends HelpPageBase {
    @FindBy(css = "div[onClick *= 'handleLoginIssue']")
    private ExtendedWebElement loginAndPasswordIssueCard;

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginAndPasswordIssuePageBase clickOnLoginAndPasswordIssueCard() {
        loginAndPasswordIssueCard.click();
        return initPage(driver, LoginAndPasswordIssuePageBase.class);
    }
}
