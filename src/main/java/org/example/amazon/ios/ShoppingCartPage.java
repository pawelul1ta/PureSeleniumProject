package org.example.amazon.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.amazon.base.ShoppingCartPageBase;
import org.example.amazon.base.SignInPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ShoppingCartPageBase.class)
public class ShoppingCartPage extends ShoppingCartPageBase {
    @FindBy(css = "input[value='Proceed to checkout']")
    private ExtendedWebElement proceedToCheckoutButton;

    @FindBy(css = "input[value*='Delete']")
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
        cartIcon.isElementPresent(12);
        return Integer.parseInt(cartIcon.getText());
    }
}
