package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebTableDependencyTest {

    WebDriver driver;

    @Test
    public void test1_verifyTitle() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");

        Assert.assertTrue(driver.getTitle().contains("DEMOQA"));
    }

    @Test(dependsOnMethods = "test1_verifyTitle")
    public void test2_addRecord() {

        driver.findElement(By.id("addNewRecordButton")).click();

        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("userEmail")).sendKeys("john@test.com");
        driver.findElement(By.id("age")).sendKeys("30");
        driver.findElement(By.id("salary")).sendKeys("5000");
        driver.findElement(By.id("department")).sendKeys("QA");

        driver.findElement(By.id("submit")).click();
    }

    @Test(dependsOnMethods = "test2_addRecord")
    public void test3_verifyRecord() {

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("John"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
