package org.example.amazon.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.amazon.base.AmazonHomePageBase;
import org.example.amazon.base.ShoppingCartPageBase;
import org.example.amazon.base.SignInPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ShoppingCartPageBase.class)
public class ShoppingCartPage extends ShoppingCartPageBase {
    @FindBy(css = "input[value='Proceed to checkout']")
    private ExtendedWebElement proceedToCheckoutButton;

    @FindBy(css = "input[value='Delete']")
    private ExtendedWebElement deleteItemLink;

    @FindBy(css = "span[id='nav-cart-count']")
    private ExtendedWebElement cartIcon;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignInPageBase proceedToCheckout() {
        proceedToCheckoutButton.click();
        return initPage(driver, SignInPageBase.class);
    }

    @Override
    public void deleteItemFromCart() {
        deleteItemLink.click();
    }

    @Override
    public int numberOfCartItems() {
        return Integer.parseInt(cartIcon.getText());
    }
}
