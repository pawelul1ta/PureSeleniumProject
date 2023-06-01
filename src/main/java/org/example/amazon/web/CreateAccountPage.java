package org.example.amazon.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.amazon.base.AmazonHomePageBase;
import org.example.amazon.base.CreateAccountPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CreateAccountPage.class)
public class CreateAccountPage extends CreateAccountPageBase {
    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    @FindBy(id = "ap_customer_name")
    private ExtendedWebElement nameInput;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CreateAccountPageBase clickContinue() {
        continueButton.click();
        return initPage(driver, CreateAccountPageBase.class);
    }

    @Override
    public boolean checkIfNameInputHasErrors() {
        return nameInput.getAttribute("class").contains("error");
    }
}
