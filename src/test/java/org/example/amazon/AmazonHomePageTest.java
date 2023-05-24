package org.example.amazon;

import base_test.AbstractTest;
import org.example.util.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AmazonHomePageTest extends AbstractTest {

    @Test
    public void searchResultsTest() {
        String url = PropertiesUtil.get("baseUrl");
        driver.get(url);

        AmazonHomePage homePage = new AmazonHomePage(driver);

        homePage.typeSearchCriteria("cat");

        int numberOfItems = homePage.getSearchResults().count();

        System.out.println("Number of found items: " + numberOfItems);

        Assert.assertTrue(numberOfItems > 0);
    }
}
