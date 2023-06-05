package org.example.amazon.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginAndPasswordIssuePageBase extends AbstractPage {
    protected LoginAndPasswordIssuePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnSelectMenuAndChooseIdontHaveAccountOpt();

    public abstract boolean isContactNumberProvided();
}
