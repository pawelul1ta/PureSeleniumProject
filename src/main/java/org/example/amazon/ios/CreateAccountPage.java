package org.example.amazon.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.amazon.base.CreateAccountPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CreateAccountPageBase.class)
public class CreateAccountPage extends CreateAccountPageBase {
    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    @FindBy(css = "h4[class=a-alert-heading]")
    private ExtendedWebElement alertHeader;

    @FindBy(id = "register_accordion_header")
    private ExtendedWebElement newCustomerLink;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CreateAccountPageBase clickContinue() {
        newCustomerLink.click();
        continueButton.click();
        return initPage(driver, CreateAccountPageBase.class);
    }

    @Override
    public boolean checkIfNameInputHasErrors() {
        return alertHeader.isElementPresent();
    }
}
