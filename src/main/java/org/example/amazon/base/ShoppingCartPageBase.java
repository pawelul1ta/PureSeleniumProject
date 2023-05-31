package org.example.amazon.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ShoppingCartPageBase extends AbstractPage {
    public ShoppingCartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignInPageBase proceedToCheckout();

    public abstract void deleteItemFromCart();

    public abstract int numberOfCartItems();
}
