package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingToCartSummary extends AbstractPage {
    @FindBy(css = "span[id='nav-cart-count']")
    private WebElement cartIcon;

    @FindBy(css = "a[id='nav-cart']")
    private WebElement cartLink;

    public AddingToCartSummary(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int numberOfCartItems() {
        return Integer.parseInt(cartIcon.getText());
    }

    public ShoppingCartPage goToTheCart() {
        click(cartLink);
        return new ShoppingCartPage(driver);
    }
}
