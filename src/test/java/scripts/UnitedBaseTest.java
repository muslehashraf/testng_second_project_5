package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedFlightResultsPage;

import java.util.List;

public class UnitedBaseTest extends UnitedBase {
    @BeforeMethod
    public void setPage() {
        unitedFlightResultsPage = new UnitedFlightResultsPage();
    }
    /*
        Test Case 1: Validate "Main menu" navigation items
        Given user is on "https://www.united.com/en/us"
        Then user should see “Main menu” navigation items
     */
    @Test(priority = 1, description = "Validate 'Main menu' navigation items")
    public void validateNavHeaders() {
        String[] expectedData = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};
        List<WebElement> actualData = unitedBasePage.navHeaderList;

        for(int i = 0; i < expectedData.length; i++) {
            Assert.assertEquals(expectedData[i], actualData.get(i).getText());
        }
    }

    /*
        Test Case 2: Validate "Book travel menu" navigation items
        Given user is on "https://www.united.com/en/us"
        Then user should see "Book travel menu" navigation items
     */
    @Test(priority = 2, description = "Validate 'Book travel menu' navigation items")
    public void validateTravelMenu() {
        String[] expectedData = {"Book", "Flight status", "Check-in", "My trips"};
        List<WebElement> actualData = unitedBasePage.travelNavTabs;

        for (int i = 0; i < expectedData.length; i++) {
            Assert.assertEquals(expectedData[i], actualData.get(i).getText());
        }
    }

    /*
        Test Case 3: Validate "Round-trip" and "One-way" radio buttons
        Given user is on "https://www.united.com/en/us"
        Then validate "Roundtrip" radio button is displayed, is enabled and is selected
        And validate "One-way" radio button is displayed, is enabled but is not selected
        When user clicks on "One-way" radio button
        Then validate "One-way" radio button is selected while "Roundtrip" radio button is
        deselected
     */
    @Test(priority = 3, description = "Validate 'Round-trip' and 'One-way' radio buttons")
    public void validateRadioButtons() {
        for (int i = 0; i < unitedBasePage.radioButtonsLabel.size(); i++) {
            Assert.assertTrue(unitedBasePage.radioButtonsLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedBasePage.radioButtonsLabel.get(i).isEnabled());
        }

        Assert.assertTrue(unitedBasePage.radioButtonsInput.get(0).isSelected());
        Assert.assertFalse(unitedBasePage.radioButtonsInput.get(1).isSelected());

        unitedBasePage.radioButtonsInput.get(1).click();

        Assert.assertFalse(unitedBasePage.radioButtonsInput.get(0).isSelected());
        Assert.assertTrue(unitedBasePage.radioButtonsInput.get(1).isSelected());
    }

    /*
        Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
        Given user is on "https://www.united.com/en/us"
        Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
        And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
        When user clicks both checkboxes
        Then validate both checkboxes are selected
        When user clicks on both selected checkboxes again
        Then validate both checkboxes are deselected
     */
    @Test(priority = 4, description = "Validate 'Book with miles' and 'Flexible dates' checkboxes")
    public void validateCheckboxes() {
        for (int i = 0; i < unitedBasePage.checkboxLabelList.size(); i++) {
            Assert.assertTrue(unitedBasePage.checkboxLabelList.get(i).isDisplayed());
            Assert.assertTrue(unitedBasePage.checkboxLabelList.get(i).isEnabled());
            Assert.assertFalse(unitedBasePage.checkboxInputList.get(i).isSelected());
        }

        // Click and validate that the checkbox is selected
        for (int i = 0; i < unitedBasePage.checkboxInputList.size(); i++) {
            unitedBasePage.checkboxLabelList.get(i).click();
            Assert.assertTrue(unitedBasePage.checkboxInputList.get(i).isSelected());
        }

        // Click and validate that the checkbox is deselected
        for (int i = 0; i < unitedBasePage.checkboxInputList.size(); i++) {
            unitedBasePage.checkboxLabelList.get(i).click();
            Assert.assertFalse(unitedBasePage.checkboxInputList.get(i).isSelected());
        }
    }

    /*
        Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to
        Miami, FL, US (MIA)”
        Given user is on "https://www.united.com/en/us"
        When user selects "One-way" ticket radio button
        And user enters "Chicago, IL, US (ORD)" to from input box
        And user enters "Miami, FL, US (MIA)" to to input box
        And user selects "Feb 28" to the dates input box
        And user selects "2 Adults" from travelers selector
        And user selects "Business or First" from cabin dropdown
        And user clicks on "Find Flights" button
        Then validate departure equals to "DEPART ON: February 28"
     */
    @Test(priority = 5, description = "Validate 'One-way' flight search results")
    public void validateOneWaySearchResults() {
        // User selects "One-way" ticket radio button
        // TODO: create a helper method to select radio button by name
        unitedBasePage.radioButtonsLabel.get(1).click();

        // User adds origin flight:
        unitedBasePage.travelFromInput.clear();
        unitedBasePage.travelFromInput.sendKeys("Chicago, IL, US (ORD)");

        // User adds destination flight:
        unitedBasePage.travelToInput.clear();
        unitedBasePage.travelToInput.sendKeys("Miami, FL, US (MIA)");

        // User add flight departure date:
        // TODO: Add a helper method to enable more date selection flexibility
        unitedBasePage.travelDepartureDate.click();
        unitedBasePage.travelDepartureDate.clear();
        unitedBasePage.travelDepartureDate.sendKeys("Feb 28");

        // User adds passenger number:
        // TODO: Add a helper method to handle multiple passenger types
        unitedBasePage.passengerCountButton.click();
        unitedBasePage.adultCountInput.sendKeys("2");

        // User select flight cabin type:
        // TODO: create a helper method to select cabin type by name
        unitedBasePage.cabinTypeButton.click();
        unitedBasePage.cabinTypeList.get(2).click();

        // User clicks on 'Find flights'
        unitedBasePage.findFlightsButton.click();

        // Validate flight results
        Assert.assertEquals(unitedFlightResultsPage.flightsResultHeading.get(1).getText(), "DEPART ON: February 28");
    }

}