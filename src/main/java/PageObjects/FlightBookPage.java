package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightBookPage extends  BasicUtilis{

    @FindBy(how = How.NAME, using = "tripType")
    private WebElement tripType_radiobox;

    @FindBy(how = How.NAME, using = "passCount")
    private WebElement passengerCount_select;

    public FlightBookPage(WebDriver driver) {
        super(driver);
        mandatory.add(tripType_radiobox);
        mandatory.add(passengerCount_select);

    }

    public void waitForMandatoryElementsForFlightBookPage() {

    }

    public String valueOfRadioButton (){
        return tripType_radiobox.getAttribute("value");
    }
}
