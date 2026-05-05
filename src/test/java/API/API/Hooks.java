package API.API;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import org.openqa.selenium.WebDriver;

public class Hooks {

    static WebDriver driver;

    @BeforeAll
    public static void init() {
        // Keep global hook lightweight; browser lifecycle is handled in UI step definitions.
        driver = null;
    }

    @AfterAll
    public static void cleanup() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Ignoring driver quit failure in @AfterAll: " + e.getMessage());
            }
        }
    }
}