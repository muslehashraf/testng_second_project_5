package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedChooseFlightsPage;
import utilities.Waiter;

import java.util.stream.IntStream;

public class UnitedBaseTest extends UnitedBase {
    @BeforeMethod
    public void setPage() {
        unitedChooseFlightsPage = new UnitedChooseFlightsPage();
    }

    @Test(priority = 1, description = "Validate 'Main menu' navigation items")
    public void validateMainMenuNavigationItems() {
        String[] expectedData = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        IntStream.range(0, expectedData.length)
                .forEach(i -> unitedBasePage.headersList.get(i).isDisplayed());
        IntStream.range(0, expectedData.length)
                .forEach(i -> Assert.assertEquals(unitedBasePage.headersList.get(i).getText(), expectedData[i]));
    }

    @Test(priority = 2, description = "Validate 'Book travel menu' navigation items")
    public void validateTravelMenuItems() {
        String[] expectedData = {"Book", "Flight status", "Check-in", "My trips"};

        for (int i = 0; i < expectedData.length; i++) {
            Assert.assertTrue(unitedBasePage.travelMenuItems.get(i).isDisplayed());
            Assert.assertEquals(unitedBasePage.travelMenuItems.get(i).getText(), expectedData[i]);
        }
    }

    @Test(priority = 3, description = "Validate 'Round-trip' and 'One-way' radio buttons")
    public void validateRadioButtons() {
        for (int i = 0; i < unitedBasePage.radioButtonsInput.size(); i++) {
            Assert.assertTrue(unitedBasePage.radioButtonsLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedBasePage.radioButtonsLabel.get(i).isEnabled());
        }

        Assert.assertTrue(unitedBasePage.radioButtonsInput.get(0).isSelected());
        Assert.assertFalse(unitedBasePage.radioButtonsInput.get(1).isSelected());

        unitedBasePage.radioButtonsInput.get(1).click();

        Assert.assertTrue(unitedBasePage.radioButtonsInput.get(1).isSelected());
        Assert.assertFalse(unitedBasePage.radioButtonsInput.get(0).isSelected());
    }

    @Test(priority = 4, description = "Validate 'Book with miles' and 'Flexible dates' checkboxes")
    public void validateCheckboxesButtons() {
        for (int i = 0; i < unitedBasePage.radioButtonsInput.size(); i++) {
            Assert.assertTrue(unitedBasePage.checkboxButtonsLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedBasePage.checkboxButtonsLabel.get(i).isEnabled());
            Assert.assertFalse(unitedBasePage.checkboxButtonsInput.get(i).isSelected());
        }

        for (int i = 0; i < unitedBasePage.checkboxButtonsInput.size(); i++) {
            unitedBasePage.checkboxButtonsLabel.get(i).click();
            Assert.assertTrue(unitedBasePage.checkboxButtonsInput.get(i).isSelected());
        }

        for (int i = 0; i < unitedBasePage.checkboxButtonsInput.size(); i++) {
            unitedBasePage.checkboxButtonsLabel.get(i).click();
            Assert.assertFalse(unitedBasePage.checkboxButtonsInput.get(i).isSelected());
        }
    }


    @Test(priority = 5, description = "Validate One-way ticket search results")
    public void validateOneWayTicketSearch() {
        unitedBasePage.radioButtonsInput.get(1).click();

        unitedBasePage.destinationInputBox.click();
        unitedBasePage.originInputBox.clear();
        unitedBasePage.originInputBox.sendKeys("Chicago, IL, US (ORD)");

        unitedBasePage.destinationInputBox.click();
        unitedBasePage.destinationInputBox.clear();
        unitedBasePage.destinationInputBox.sendKeys("Miami, FL, US (MIA)");

        unitedBasePage.departureDateInput.click();
        unitedBasePage.departureDateInput.clear();
        unitedBasePage.departureDateInput.sendKeys("02/28/2023");

        unitedBasePage.travelersButton.click();
        unitedBasePage.addAdults(3);

        unitedBasePage.cabinTypeButton.click();
        unitedBasePage.selectCabinType("Business or first");

        unitedBasePage.findFlightsButton.click();

        Assert.assertTrue(unitedChooseFlightsPage.detailHeading.isDisplayed());
        Assert.assertEquals(unitedChooseFlightsPage.detailHeading.getText(), "DEPART ON: February 28");
    }
}