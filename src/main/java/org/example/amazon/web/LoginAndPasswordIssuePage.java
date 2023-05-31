package org.example.amazon.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.amazon.base.AmazonHomePageBase;
import org.example.amazon.base.LoginAndPasswordIssuePageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginAndPasswordIssuePage.class)
public class LoginAndPasswordIssuePage extends LoginAndPasswordIssuePageBase {
    @FindBy(xpath = "//div[@class='cu-dyk-text']/p[contains(text(), \"call us\")]")
    private ExtendedWebElement contactInformationText;

    public LoginAndPasswordIssuePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnSelectMenuAndChooseIdontHaveAccountOpt() {
        WebElement issueSelect = driver.findElement(By.id("cu-select-firstNode"));
        Select select = new Select(issueSelect);
        select.selectByValue("4");
    }

    @Override
    public boolean isContactNumberProvided() {
        return contactInformationText.isElementPresent();
    }
}
