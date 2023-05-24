package org.example.amazon;

import org.example.base_page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginAndPasswordIssuePage extends AbstractPage {
    @FindBy(id = "cu-select-firstNode")
    private WebElement issueSelect;

    @FindBy(css = "option[name*='I do not have an Amazon account but']")
    private WebElement iDontHaveAccountOption;

    @FindBy(xpath = "//div[@class='cu-dyk-text']/p[contains(text(), \"call us\")]")
    private WebElement contactInformationText;

    public LoginAndPasswordIssuePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnSelectMenuAndChooseIdontHaveAccountOpt() {
        wait.until(ExpectedConditions.visibilityOf(issueSelect));
        Select select = new Select(issueSelect);
        select.selectByVisibleText("I do not have an Amazon account but need assistance");
    }

    public boolean isContactNumberProvided() {
        return isElementVisible(contactInformationText);
    }
}
