package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnitedChooseFlightsPage extends UnitedBasePage {
    public UnitedChooseFlightsPage() {
        super();
    }

    @FindBy(xpath = "(//div[contains(@class, 'detailHeading')]//span)[2]")
    public WebElement detailHeading;
}