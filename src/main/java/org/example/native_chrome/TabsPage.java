package org.example.native_chrome;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TabsPage extends AbstractPage {
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"New tab\"]")
    private ExtendedWebElement addNewTabButton;

    public TabsPage(WebDriver driver) {
        super(driver);
    }

    public ChromeMainPage addNewTab() {
        addNewTabButton.click();
        return new ChromeMainPage(driver);
    }
}
