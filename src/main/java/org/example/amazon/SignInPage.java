package org.example.amazon;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {
    @FindBy(css = "div[class='a-box']")
    private ExtendedWebElement signInForm;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignInFormPresent() {
        return signInForm.isElementPresent();
    }
}
