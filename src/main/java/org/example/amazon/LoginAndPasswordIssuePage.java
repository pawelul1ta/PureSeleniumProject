package org.example.amazon;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginAndPasswordIssuePage extends AbstractPage {
    @FindBy(xpath = "//div[@class='cu-dyk-text']/p[contains(text(), \"call us\")]")
    private ExtendedWebElement contactInformationText;

    public LoginAndPasswordIssuePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSelectMenuAndChooseIdontHaveAccountOpt() {
        WebElement issueSelect = driver.findElement(By.id("cu-select-firstNode"));
        Select select = new Select(issueSelect);
        select.selectByValue("4");
    }

    public boolean isContactNumberProvided() {
        return contactInformationText.isElementPresent();
    }
}
