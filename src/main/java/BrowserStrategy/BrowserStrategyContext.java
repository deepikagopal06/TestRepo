package BrowserStrategy;

import BrowserStrategy.NormalBrowserStrategy.ChromeBrowserStrategy;
import org.openqa.selenium.WebDriver;


public class BrowserStrategyContext {

    private BrowserStrategy browserStrategy;
    private String brChoice = System.getProperty("browser").toString();

    public WebDriver getBrowser() {
        if (brChoice.equals("Chrome")) {
            browserStrategy = new ChromeBrowserStrategy();

        }
        return browserStrategy.setBrowserConfiguration();
    }
}
