package pages;

import org.openqa.selenium.WebDriver;
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
    public List<WebElement> navHeaderList;

    @FindBy(css = "ul[class*='travelNav']>li")
    public List<WebElement> travelNavTabs;

    @FindBy(css = "div[class*='radioContainer']>label")
    public List<WebElement> radioButtonsLabel;

    @FindBy(css = "div[class*=radioContainer] input")
    public List<WebElement> radioButtonsInput;

    @FindBy(css = "div[class*='checkboxWrapper']>label")
    public List<WebElement> checkboxLabelList;

    @FindBy(css = "div[class*='checkboxWrapper'] input")
    public List<WebElement> checkboxInputList;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement travelFromInput;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement travelToInput;

    @FindBy(id = "DepartDate")
    public  WebElement travelDepartureDate;

    @FindBy(css = "div[id='passengerSelector']>button")
    public WebElement passengerCountButton;

    @FindBy(css = "div[id=passengerSelector] input")
    public WebElement adultCountInput;

    @FindBy(css = "button[id=cabinType]")
    public WebElement cabinTypeButton;

    @FindBy(css = "li[id*=cabinType_item]")
    public List<WebElement> cabinTypeList;

    @FindBy(css = "button[class*=findFlightBtn]")
    public WebElement findFlightsButton;
}