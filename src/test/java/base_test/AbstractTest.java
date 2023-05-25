package base_test;

import org.example.driver.DriverFactory;
import org.example.util.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

public class AbstractTest {
    protected ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    @Parameters("browserType")
    public void driverSetup(@Optional("chrome") String browserType) throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.create(browserType, PropertiesUtil.get("hubUrl"));

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driverThreadLocal.set(webDriver);

    }

    private WebDriver getDriverThreadLocal() {
       return driverThreadLocal.get();
    }

    @AfterMethod
    public void tearDown() {
        if(getDriverThreadLocal() != null) {
            getDriverThreadLocal().quit();
        }
    }
    @AfterClass
    public void terminate () {
        //Remove the ThreadLocalMap element
        driverThreadLocal.remove();
    }
}
