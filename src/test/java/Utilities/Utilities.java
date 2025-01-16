package Utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Calendar;

public class Utilities {

    // Method to calculate the arrival date based on departure date and number of days to stay
    public static String[] calculateFlightDates(String departureDate, int numberOfDaysToStay) {
        // Define a date format for input and output
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the departure date from string to LocalDate
        LocalDate departure = LocalDate.parse(departureDate, formatter);

        // Calculate the arrival date by adding the number of days to stay
        LocalDate arrival = departure.plusDays(numberOfDaysToStay);

        // Format the departure and arrival dates back to string
        String formattedDepartureDate = departure.format(formatter);
        String formattedArrivalDate = arrival.format(formatter);

        // Return both dates as a string array
        return new String[] {formattedDepartureDate, formattedArrivalDate};
    }

}


