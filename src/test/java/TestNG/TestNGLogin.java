package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGLogin {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginTest() {

        // Validate title
        Assert.assertEquals(driver.getTitle(), "The Internet");

        // Login
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Validate success message
        String message = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(message.contains("You logged into a secure area!"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
