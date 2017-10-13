package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login extends BasicUtilis {

    @FindBy(how = How.NAME, using = "userName")
    private WebElement userName_textBox;

    @FindBy(how = How.NAME, using = "password")
    private WebElement password_textBox;

    @FindBy(how = How.NAME, using = "login")
    private WebElement login_button;



    public Login(WebDriver driver) {
        super(driver);
        mandatory.add(userName_textBox);
        mandatory.add(password_textBox);
    }

    public void waitForMandatoryElementForLoginPage (){
        waitForMandatoryElements();
    }

    public void enterUserName (String uName){
        userName_textBox.sendKeys(uName);
    }

    public void enterPassword (String password){
        password_textBox.sendKeys(password);
    }

    public void clickSubmitButton (){
        login_button.click();
    }
}
