package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginAndPasswordIssuePage extends AbstractPage {
    @FindBy(id = "cu-select-firstNode")
    private WebElement issueSelect;

    @FindBy(xpath = "//div[@class='cu-dyk-text']/p[contains(text(), \"call us\")]")
    private WebElement contactInformationText;

    public LoginAndPasswordIssuePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSelectMenuAndChooseIdontHaveAccountOpt() {
        Select select = new Select(issueSelect);
        select.selectByValue("4");
    }

    public boolean isContactNumberProvided() {
        return isElementVisible(contactInformationText);
    }
}
