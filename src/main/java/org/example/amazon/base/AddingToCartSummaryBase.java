package org.example.amazon.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AddingToCartSummaryBase extends AbstractPage {
    public AddingToCartSummaryBase(WebDriver driver) {
        super(driver);
    }

    public abstract int numberOfCartItems();

    public abstract ShoppingCartPageBase goToTheCart();
}
