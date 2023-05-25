package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends AbstractPage {
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public AddingToCartSummary addProductToTheCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        click(addToCartButton);
        return new AddingToCartSummary(driver);
    }
}
