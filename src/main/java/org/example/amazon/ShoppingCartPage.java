package org.example.amazon;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {
    @FindBy(css = "input[value='Proceed to checkout']")
    private ExtendedWebElement proceedToCheckoutButton;

    @FindBy(css = "input[value='Delete']")
    private ExtendedWebElement deleteItemLink;

    @FindBy(css = "span[id='nav-cart-count']")
    private ExtendedWebElement cartIcon;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage proceedToCheckout() {
        proceedToCheckoutButton.click();
        return new SignInPage(driver);
    }

    public void deleteItemFromCart() {
        deleteItemLink.click();
    }

    public int numberOfCartItems() {
        return Integer.parseInt(cartIcon.getText());
    }
}
