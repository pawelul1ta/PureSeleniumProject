package org.example.amazon.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.amazon.base.LoginAndPasswordIssuePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginAndPasswordIssuePageBase.class)
public class LoginAndPasswordIssuePage extends LoginAndPasswordIssuePageBase {
    @FindBy(xpath = "//div[@class='cu-dyk-text']/p[contains(text(), \"call us\")]")
    private ExtendedWebElement contactInformationText;

    @FindBy(id = "cu-select-firstNode")
    private ExtendedWebElement select;

    @FindBy(css = "option[value='4']")
    private ExtendedWebElement iDontHaveAccOpt;

    public LoginAndPasswordIssuePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnSelectMenuAndChooseIdontHaveAccountOpt() {
        select.click();
        iDontHaveAccOpt.click();
    }

    @Override
    public boolean isContactNumberProvided() {
        return contactInformationText.isElementPresent();
    }
}
