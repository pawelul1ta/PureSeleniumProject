package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPage {
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AddingToCartSummary addProductToTheCart() {
        click(addToCartButton);
        return new AddingToCartSummary(driver);
    }
}
