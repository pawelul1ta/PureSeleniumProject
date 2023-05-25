package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends AbstractPage {
    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "ap_customer_name")
    private WebElement nameInput;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage clickContinue() {
        click(continueButton);
        return new CreateAccountPage(driver);
    }

    public boolean checkIfNameInputHasErrors() {
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        return nameInput.getAttribute("class").contains("error");
    }
}
