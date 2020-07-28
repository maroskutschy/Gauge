package gauge_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required browser can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    public static WebDriver getDriver() {

        String browser = System.getenv("BROWSER");
        switch (browser)
        {
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/" + "WINDOWS" + "/geckodriver.exe");
                return new FirefoxDriver();
            case "IE":
                System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/" + "WINDOWS" + "/geckodriver.exe");
                return new InternetExplorerDriver();
            default:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/" + "WINDOWS" + "/chromedriver.exe");
                // DISABLE CHROME NOTIFICATIONS:
                // Create object of HashMap Class
                Map<String, Object> prefs = new HashMap<String, Object>();
                // Set the notification setting it will override the default setting
                prefs.put("profile.default_content_setting_values.notifications", 2);
                // Create object of ChromeOption class
                ChromeOptions options = new ChromeOptions();
                // Set the experimental option
                options.setExperimentalOption("prefs", prefs);

                return new ChromeDriver(options);

        }
    }
}
