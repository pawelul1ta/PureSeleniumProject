package base_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class AbstractTest {
        protected WebDriver driver;

        @BeforeTest
        public void setup () {
            driver = new ChromeDriver();

        }
        @AfterTest
        public void teardown () {
            driver.quit();
        }

}
