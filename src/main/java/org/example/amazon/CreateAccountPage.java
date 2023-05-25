package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends AbstractPage {
    @FindBy(id = "continue")
    private WebElement continueButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CreateAccountPage clickContinue() {
        click(continueButton);
        return new CreateAccountPage(driver);
    }

    public boolean checkIfNameInputHasErrors() {
        WebElement nameInput = driver.findElement(By.id("ap_customer_name"));
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        return nameInput.getAttribute("class").contains("error");
    }
}
