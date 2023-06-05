package org.example.amazon.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.amazon.base.AddingToCartSummaryBase;
import org.example.amazon.base.AmazonHomePageBase;
import org.example.amazon.base.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {
    @FindBy(id = "add-to-cart-button")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AddingToCartSummaryBase addProductToTheCart() {
        addToCartButton.click();
        return initPage(driver, AddingToCartSummaryBase.class);
    }
}
