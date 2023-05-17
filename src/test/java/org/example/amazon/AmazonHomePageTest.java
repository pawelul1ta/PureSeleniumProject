package org.example.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AmazonHomePageTest {

    @Test
    public void searchResultsTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        AmazonHomePage homePage = new AmazonHomePage(driver);

        homePage.typeSearchCriteria("cat");

        int numberOfItems = homePage.getSearchResults().count();

        System.out.println("Number of found items: " + numberOfItems);

        Assert.assertTrue(numberOfItems > 0);
    }

}
