package StepDefination;

import POM.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class webDriver {
    WebDriver driver;
    LoginPage loginPage;

    @Test
    @Given("user is on login page")
    public void openLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("OrangeHRM"));
        loginPage.login("Admin","admin123");
    }

    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should be logged in successfully")
    public void verifyLoginSuccess() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        alert.accept();
//        Assert.assertTrue(driver.getCurrentUrl().contains("Swag Labs"));
//        driver.quit();


//        String currentUrl = driver.getCurrentUrl();
//        System.out.println(currentUrl);
//        if (currentUrl.contains("inventory")) {
//            System.out.println("Login successful");
//        } else {
//            System.out.println("Login failed");
//        }
    }

    @Then("user should see login result {string}")
    public void verifyLoginResult(String result) {
        if (result.equals("success")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("Products"));
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed());
        }
        driver.quit();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
