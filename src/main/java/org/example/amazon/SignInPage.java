package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {
    @FindBy(css = "div[class='a-box']")
    private WebElement signInForm;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignInFormPresent() {
        return isElementVisible(signInForm);
    }
}
