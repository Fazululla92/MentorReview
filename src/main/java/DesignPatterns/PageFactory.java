package DesignPatterns;

import Drivers.MyChromeDriver;
import Drivers.MyFirefoxDriver;
import Drivers.MyIEDriver;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    public static WebDriver createDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            return new MyChromeDriver().getDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            return new MyFirefoxDriver().getDriver();

        } else if (browser.equalsIgnoreCase("ie")) {
            return new MyIEDriver().getDriver();
        }

        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
}
