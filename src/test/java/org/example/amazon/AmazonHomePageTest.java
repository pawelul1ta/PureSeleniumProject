package org.example.amazon;

import base_test.AbstractTest;
import org.example.util.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonHomePageTest extends AbstractTest {

    @Test
    public void searchResultsTest() throws InterruptedException {
        WebDriver driver = driverThreadLocal.get();
        String url = PropertiesUtil.get("baseUrl");
        driver.get(url);

        AmazonHomePage homePage = new AmazonHomePage(driver);

        homePage.typeSearchCriteria("cat");

        int numberOfItems = homePage.getSearchResults().count();

        System.out.println("Number of found items: " + numberOfItems);

        Assert.assertTrue(numberOfItems > 0);
    }
}
