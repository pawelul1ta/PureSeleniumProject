package org.example.amazon;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.amazon.web.AmazonHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonHomePageTest implements IAbstractTest {

    @Test
    public void searchResultsTest() throws InterruptedException {


        AmazonHomePage homePage = new AmazonHomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();

        homePage.typeSearchCriteria("cat");

        int numberOfItems = homePage.getSearchResults().count();

        System.out.println("Number of found items: " + numberOfItems);

        Assert.assertTrue(numberOfItems > 0);
    }
}
