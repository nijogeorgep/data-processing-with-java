/**
 *
 */
package com.cloudwalker.dateTime;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

/**
 * @author nijogeorgep
 *
 */
public class LocalDateDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Current Date
        LocalDate today = LocalDate.now();
        System.out.println("Current Date " + today);

        // Create LocalDate by providing arguments
        LocalDate firstDay_2018 = LocalDate.of(2018, Month.JANUARY, 1);
        System.out.println("Specific Date : " + firstDay_2018);

        // CurrentDate in another timeZone
        LocalDate todayGermany = LocalDate.now(ZoneId.of("Europe/Copenhagen"));
        System.out.println("Date at Germany : " + todayGermany);

        // Getting date from the base date i.e 01/01/1970
        LocalDate dateFormBase = LocalDate.ofEpochDay(365);
        System.out.println("Date from Base : " + dateFormBase);

        // Get specific Day of year
        LocalDate hundredsDay2018 = LocalDate.ofYearDay(2018, 300);
        System.out.println("3 Hundred's Day of 2018 : " + hundredsDay2018);
    }

}
