package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirefoxDriver {

    private WebDriver driver;

    public MyFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "/path/geckodriver");
        this.driver = new FirefoxDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
