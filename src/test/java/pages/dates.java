package pages;

import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dates {
    // Test case 2: Testing with a stay duration of 0 days (same day arrival)
    @Test
    public void testCalculateFlightDates_ZeroStay() {
        String departureDate = "2025-02-01";
        int numberOfDaysToStay = 0;

        // Expected arrival date is the same as departure
        String[] flightDates = Utilities.calculateFlightDates(departureDate, numberOfDaysToStay);

        // Assert that the calculated dates are correct
        Assert.assertEquals(flightDates[0], "2025-02-01", "Departure date is incorrect");
        Assert.assertEquals(flightDates[1], "2025-02-01", "Arrival date is incorrect");
    }

    // Test case 3: Testing a leap year (February 29th)
    @Test
    public void testCalculateFlightDates_LeapYear() {
        String departureDate = "2024-02-28"; // Leap year scenario
        int numberOfDaysToStay = 2;

        // Expected arrival date is 2024-03-01 (because 2024 is a leap year)
        String[] flightDates = Utilities.calculateFlightDates(departureDate, numberOfDaysToStay);

        // Assert that the calculated dates are correct
        Assert.assertEquals(flightDates[0], "2024-02-28", "Departure date is incorrect");
        Assert.assertEquals(flightDates[1], "2024-03-01", "Arrival date is incorrect");
    }

    // Test case 4: Testing with a large number of days (e.g., 365 days)
    @Test
    public void testCalculateFlightDates_LargeStay() {
        String departureDate = "2025-01-01";
        int numberOfDaysToStay = 365;

        // Expected arrival date should be 2025-12-31
        String[] flightDates = Utilities.calculateFlightDates(departureDate, numberOfDaysToStay);

        // Assert that the calculated dates are correct
        Assert.assertEquals(flightDates[0], "2025-01-01", "Departure date is incorrect");
        Assert.assertEquals(flightDates[1], "2025-12-31", "Arrival date is incorrect");
    }
}
