package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MyIEDriver {

    private WebDriver driver;

    public MyIEDriver() {
        System.setProperty("webdriver.ie.driver", "/path/iedriver");
        this.driver = new InternetExplorerDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
