package org.example.amazon.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.amazon.base.AddingToCartSummaryBase;
import org.example.amazon.base.ShoppingCartPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AddingToCartSummaryBase.class)
public class AddingToCartSummary extends AddingToCartSummaryBase {
    @FindBy(id="nav-cart-count")
    private ExtendedWebElement cartIcon;

    @FindBy(css = "span[id='ace-gtc'] a")
    private ExtendedWebElement cartLink;

    public AddingToCartSummary(WebDriver driver) {
        super(driver);
    }

    @Override
    public int numberOfCartItems() {
        cartIcon.isElementPresent(12);
        return Integer.parseInt(cartIcon.getText());
    }

    @Override
    public ShoppingCartPageBase goToTheCart() {
        cartLink.click();
        return initPage(driver, ShoppingCartPageBase.class);
    }
}
