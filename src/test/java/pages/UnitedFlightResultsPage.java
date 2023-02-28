package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UnitedFlightResultsPage extends UnitedBasePage {
    public UnitedFlightResultsPage() {
        super();
    }

    @FindBy(css = "div[class*=detailHeading]>span")
    public List<WebElement> flightsResultHeading;
}