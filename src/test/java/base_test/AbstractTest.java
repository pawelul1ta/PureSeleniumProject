package base_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AbstractTest {
        protected WebDriver driver;

        @BeforeMethod
        public void setup () {
            driver = new ChromeDriver();
        }

        @AfterMethod
        public void teardown () {
            driver.quit();
        }
}
