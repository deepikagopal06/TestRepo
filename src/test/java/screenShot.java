import BrowserStrategy.BrowserStrategy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import BrowserStrategy.BrowserStrategy;
import BrowserStrategy.BrowserStrategyContext;

public class screenShot extends TestListenerAdapter {

    private WebDriver driver;
    private BrowserStrategy browserStrategy;
    private BrowserStrategyContext browserStrategyContext;


    public void takeScreenShot(ITestResult result){

        File screenShotName;
        //if (ITestResult.FAILURE == result.getStatus()){
        try {
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);

            screenShotName = new File("/target/surefire-reports/Screenshots/"+result.getName()+".png");
            FileUtils.copyFile(source, screenShotName);

            String filePath = screenShotName.toString();
            Reporter.log("<a href='"+ screenShotName.getAbsolutePath() + "'> <img src='"+ screenShotName.getAbsolutePath() + "' height='100' width='100'/> </a>");
            System.out.println("Screenshot taken");
        }
        catch (Exception e)
        {

            System.out.println("Exception while taking screenshot "+e.getMessage());
        }

     }

    }
