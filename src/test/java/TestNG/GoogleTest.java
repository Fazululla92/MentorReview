package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @Test
    public void verifyTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }

    @Test
    public void verifyPageLoad() {
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
