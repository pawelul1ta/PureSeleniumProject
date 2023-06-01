package org.example.amazon.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HelpPageBase extends AbstractPage {
    public HelpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginAndPasswordIssuePageBase clickOnLoginAndPasswordIssueCard();
}
