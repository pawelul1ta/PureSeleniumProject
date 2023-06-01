package org.example.amazon.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageBase extends AbstractPage {
    public SignInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isSignInFormPresent();
}
