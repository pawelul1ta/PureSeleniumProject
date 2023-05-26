package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {
    @FindBy(css = "input[value='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteItemLink;

    @FindBy(css = "span[id='nav-cart-count']")
    private WebElement cartIcon;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage proceedToCheckout() {
        click(proceedToCheckoutButton);
        return new SignInPage(driver);
    }

    public void deleteItemFromCart() {
        click(deleteItemLink);
    }

    public int numberOfCartItems() {
        return Integer.parseInt(cartIcon.getText());
    }
}
