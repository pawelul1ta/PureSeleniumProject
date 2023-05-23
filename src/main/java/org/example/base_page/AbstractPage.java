package org.example.base_page;

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
    public WebDriver driver;
    public WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        logger.info("Element is clicked");
    }

    public void writeText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
        logger.info("Text is typed in the element");
    }

    public Actions hoverMouseOver(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        logger.info("mouse pointer is moved to the element");
        return action;
    }
}
