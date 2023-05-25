package org.example.base_page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AbstractPage {
    private static Logger logger = LoggerFactory.getLogger(AbstractPage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

        logger.info(element + " is clicked");
    }

    public void writeText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
        logger.info("\"" + text + "\"" + " is typed in the " + element.getAttribute("id"));
    }

    public void hoverMouseOver(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        logger.info("mouse pointer is moved to the " + element.getAccessibleName());
    }

    public boolean isElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void scrollDownThePage() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }
}
