package MentorNotes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class waitTypes {
    static void main() throws InterruptedException {
//        1. Object-level Wait
        String s = new String();
        s.wait(1000);
//        Thread sleep wait
        Thread.sleep(2000); // sleep for 2 seconds

//        selenium waits
//        1. Implicit Wait
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        If element is not found immediately, Selenium will wait for a fixed time before throwing an exception.

//        2. Explicit Wait (Most Important)
        WebDriverWait ew = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement element = ew.until(ExpectedConditions.visibilityOfElementLocated(By.id("checking")));

//        Waits for a specific condition on a specific element(like visibility, clickability)

//        3.Fluent wait
        FluentWait<ChromeDriver> fw = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement dummy = fw.until(d -> d.findElement(By.id("check")));


//        Think of ordering food in a restaurant 🍽️:
//
//        Implicit Wait → You wait for all food items generally

//        Explicit Wait → You wait only for pizza to be ready 🍕

//        Fluent Wait → You keep checking kitchen every 2 minutes and skip delays
        //(Check every 2 minutes if bus arrived (polling)
        //Wait max 15 minutes (timeout)
        //Ignore small delays (exceptions)

    }
}
