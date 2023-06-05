package org.example.amazon;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.amazon.base.AmazonHomePageBase;
import org.example.native_chrome.ChromeMainPage;
import org.example.native_chrome.TabsPage;
import org.example.utils.MobileContextUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextTest implements IAbstractTest {

    @Test
    public void switchingContextTest() {
        AmazonHomePageBase homePage = initPage(getDriver(), AmazonHomePageBase.class);
        homePage.open();

        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);

        ChromeMainPage chromeMainPage = new ChromeMainPage(getDriver());
        TabsPage tabsPage = chromeMainPage.goToTabs();
        ChromeMainPage chromeMainPage2 = tabsPage.addNewTab();

        Assert.assertEquals(chromeMainPage2.getTotalNumberOfTabs(), 2);
    }
}
