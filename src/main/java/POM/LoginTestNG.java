package POM;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;

public class LoginTestNG {
    WebDriver driver;

//    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @Test
    public void testTitle() {
        String title = driver.getTitle();
        System.out.println(title);
    }

//    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}