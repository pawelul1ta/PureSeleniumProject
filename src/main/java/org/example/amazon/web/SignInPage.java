package org.example.amazon.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.amazon.base.SignInPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {
    @FindBy(css = "div[class='a-box']")
    private ExtendedWebElement signInForm;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSignInFormPresent() {
        return signInForm.isElementPresent();
    }
}
