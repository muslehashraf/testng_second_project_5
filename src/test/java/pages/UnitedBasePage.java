package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UnitedBasePage {
    public UnitedBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[id*='headerNav']")
    public List<WebElement> headersList;

    @FindBy(css = "ul[class*='bookTravel__']>li")
    public List<WebElement> travelMenuItems;

    @FindBy(css = "div[class*='__radioContainer'] label")
    public List<WebElement> radioButtonsLabel;

    @FindBy(css = "div[class*='__radioContainer'] input")
    public List<WebElement> radioButtonsInput;

    @FindBy(css = "div[class*='__checkboxWrapper']>label")
    public List<WebElement> checkboxButtonsLabel;

    @FindBy(css = "div[class*='__checkboxWrapper']>input")
    public List<WebElement> checkboxButtonsInput;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement originInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement destinationInputBox;

    @FindBy(id = "DepartDate")
    public WebElement departureDateInput;

    @FindBy(xpath = "(//div[contains(@class, '2Occ')])[1]/button[2]")
    private WebElement addAdultButton;

    @FindBy(css = "#passengerSelector>button")
    public WebElement travelersButton;


    @FindBy(id = "cabinType")
    public WebElement cabinTypeButton;

    @FindBy(css = "div[class*='2-kSS'] li")
    private List<WebElement> cabinTypeList;

    @FindBy(css = "button[class*='2fg9l']")
    public WebElement findFlightsButton;

    public void addAdults(int num) {
        int i = 1;

        while(i <= num) {
            addAdultButton.click();
            i++;
        }
    }

    public void selectCabinType(String cabin) {
        for(WebElement c : cabinTypeList) {
            if(c.getText().toLowerCase().equals(cabin.toLowerCase())) {
                c.click();
                break;
            }
        }
    }
}