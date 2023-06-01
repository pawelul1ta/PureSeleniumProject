package org.example.amazon.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CreateAccountPageBase extends AbstractPage {
    public CreateAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CreateAccountPageBase clickContinue();
    public abstract boolean checkIfNameInputHasErrors();
}
