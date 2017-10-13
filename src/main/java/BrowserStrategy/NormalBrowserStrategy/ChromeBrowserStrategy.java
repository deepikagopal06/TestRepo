package BrowserStrategy.NormalBrowserStrategy;

import BrowserStrategy.BrowserStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.lang3.SystemUtils;

import java.util.logging.Level;

public class ChromeBrowserStrategy implements BrowserStrategy {

    private DesiredCapabilities capabilities;
    private WebDriver driver;


    public WebDriver setBrowserConfiguration() {
        ChromeOptions options = new ChromeOptions();

        if (SystemUtils.IS_OS_MAC) {
            System.out.println("System is identified as mac operating system");
            System.setProperty("webdriver.chrome.driver", "drivers/mac/chromedriver");
            LoggingPreferences logs = new LoggingPreferences();
            logs.enable(LogType.BROWSER, Level.ALL);
            logs.enable(LogType.DRIVER, Level.ALL);
            // Disable extensions along with incognito mode as linux webdriver stucks due to extension plugin.
            options.addArguments("--incognito", "--disable-extensions", "--start-fullscreen");

            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
            driver = new ChromeDriver(capabilities);


    }

        return driver;
    }

}
