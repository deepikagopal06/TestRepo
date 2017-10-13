package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class BasicUtilis {
    protected WebDriver driver;
    protected List<WebElement> mandatory = new ArrayList<WebElement>();

    public BasicUtilis (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitForElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitForMandatoryElements (){
        waitForElements(mandatory);
    }


}
