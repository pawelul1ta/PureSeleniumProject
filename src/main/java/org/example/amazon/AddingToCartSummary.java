package org.example.amazon;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddingToCartSummary extends AbstractPage {
    @FindBy(css = "span[id='nav-cart-count']")
    private ExtendedWebElement cartIcon;

    @FindBy(css = "a[id='nav-cart']")
    private ExtendedWebElement cartLink;

    public AddingToCartSummary(WebDriver driver) {
        super(driver);
    }

    public int numberOfCartItems() {
        return Integer.parseInt(cartIcon.getText());
    }

    public ShoppingCartPage goToTheCart() {
        cartLink.click();
        return new ShoppingCartPage(driver);
    }
}
