package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyChromeDriver {

    private WebDriver driver;

    public MyChromeDriver() {
        // encapsulated initialization
        System.setProperty("webdriver.chrome.driver", "/path/chromedriver");
        this.driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
