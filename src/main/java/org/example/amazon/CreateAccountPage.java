package org.example.amazon;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends AbstractPage {
    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    @FindBy(id = "ap_customer_name")
    private ExtendedWebElement nameInput;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage clickContinue() {
        continueButton.click();
        return new CreateAccountPage(driver);
    }

    public boolean checkIfNameInputHasErrors() {
        return nameInput.getAttribute("class").contains("error");
    }
}
