package org.example.native_chrome;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChromeMainPage extends AbstractPage {
    @FindBy(id = "com.android.chrome:id/tab_switcher_button")
    private ExtendedWebElement tabSwitcherButton;

    public ChromeMainPage(WebDriver driver) {
        super(driver);
    }

    public TabsPage goToTabs() {
        tabSwitcherButton.click();
        return new TabsPage(driver);
    }

    public int getTotalNumberOfTabs() {
        return Integer.parseInt(tabSwitcherButton.getAttribute("content-desc").substring(0,1));
    }

}
