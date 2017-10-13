import BrowserStrategy.BrowserStrategy;
import BrowserStrategy.BrowserStrategyContext;
import PageObjects.BasicUtilis;
import PageObjects.FlightBookPage;
import PageObjects.Login;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class TestLogin {

    private Login login;
    private FlightBookPage flightBookPage;
    private WebDriver driver;
    private BrowserStrategy browserStrategy;
    private BrowserStrategyContext browserStrategyContext;
    private String websiteURL;

    @BeforeTest
    public void testSetup(){
        browserStrategyContext = new BrowserStrategyContext();
        driver = browserStrategyContext.getBrowser();
        login = new Login(driver);
        flightBookPage = new FlightBookPage(driver);
    }

    @Test (priority = 0)

    public void launchWebsite (){
        websiteURL =  System.getProperty("env").toString();
        driver.get(websiteURL);
        //driver.get("http://newtours.demoaut.com/");
        login.waitForMandatoryElementForLoginPage();
    }

    @Test (priority = 1)

    public void enterLoginDetails () throws InterruptedException {
        login.enterUserName("audibene");
        login.enterPassword("audibene");
        login.clickSubmitButton();
        //Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void enterFlightDetails(){
        flightBookPage.waitForMandatoryElementsForFlightBookPage();
        Assert.assertEquals(flightBookPage.valueOfRadioButton(),"roundtrip");
    }

    @AfterTest
    public void tearDown() {

        File screenShotName;
        //if (ITestResult.FAILURE == result.getStatus()){
            try {
                TakesScreenshot ts=(TakesScreenshot)driver;
                File source=ts.getScreenshotAs(OutputType.FILE);

                screenShotName = new File("target/surefire-reports/Screenshots/deepika.png");
                FileUtils.copyFile(source, screenShotName);
                System.out.println("The name of the file is " +screenShotName.toString());

                String filePath = screenShotName.toString();
                Reporter.log("<a href='"+ screenShotName.getAbsolutePath() + "'> <img src='"+ screenShotName.getAbsolutePath() + "' height='100' width='100'/> </a>");
                System.out.println("Screenshot taken");
            }
            catch (Exception e)
            {

                System.out.println("Exception while taking screenshot " +e.getMessage());
            }
        //}

        driver.close();
        driver.quit();
    }

}
