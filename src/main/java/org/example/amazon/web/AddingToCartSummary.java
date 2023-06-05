package org.example.amazon.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.amazon.base.AddingToCartSummaryBase;
import org.example.amazon.base.ShoppingCartPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AddingToCartSummaryBase.class)
public class AddingToCartSummary extends AddingToCartSummaryBase {
    @FindBy(css = "span[id='nav-cart-count']")
    private ExtendedWebElement cartIcon;

    @FindBy(css = "a[id='nav-cart']")
    private ExtendedWebElement cartLink;

    public AddingToCartSummary(WebDriver driver) {
        super(driver);
    }

    @Override
    public int numberOfCartItems() {
        return Integer.parseInt(cartIcon.getText());
    }

    @Override
    public ShoppingCartPageBase goToTheCart() {
        cartLink.click();
        return initPage(driver, ShoppingCartPageBase.class);
    }
}
