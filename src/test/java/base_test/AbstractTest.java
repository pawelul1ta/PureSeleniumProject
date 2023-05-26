package base_test;

import org.apache.commons.io.FileUtils;
import org.example.driver.DriverFactory;
import org.example.util.PropertiesUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class AbstractTest {
    private final String FILE_PATH = "/Users/pawelulita/Desktop/dev/screenshots/";
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

    @AfterMethod
    public void screenshot(ITestResult result) {
        if (!result.isSuccess()) {
            TakesScreenshot tc = (TakesScreenshot) getDriverThreadLocal();
            File scrFile = tc.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(FILE_PATH + result.getName() + ".png"));
                System.out.println("***Placed screen shot in " + FILE_PATH + " ***");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private WebDriver getDriverThreadLocal() {
        return driverThreadLocal.get();
    }

    @AfterMethod
    public void tearDown() {
        if (getDriverThreadLocal() != null) {
            getDriverThreadLocal().quit();
        }
    }

    @AfterClass
    public void terminate() {
        driverThreadLocal.remove();
    }
}
