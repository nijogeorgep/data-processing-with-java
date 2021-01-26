/**
 *
 */
package com.cloudwalker.dateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

/**
 * @author nijogeorgep
 *
 */
public class DateAPIUtilities {

    /**
     * @param args
     */
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        // Get the Year, check if it's leap year
        System.out.println(" Year " + today.getYear() + " is leap year?" + today.isLeapYear());

        // Compare two LocalDate for before and after
        System.out.println("Today is before 01/01/2015? " + today.isBefore(LocalDate.of(2015, 01, 01)));
        System.out.println("Today is before 01/01/2015? " + today.isAfter(LocalDate.of(2015, 01, 01)));

        // Create LocalDateTime from LocalDate
        System.out.println("Current Time : " + today.atTime(LocalTime.now()));

        // plus and minus operations
        System.out.println("10 days after today will be " + today.plusDays(10));
        System.out.println("3 weeks after today will be " + today.plusWeeks(3));
        System.out.println("20 months after today will be " + today.plusMonths(20));

        System.out.println("10 days before today was " + today.minusDays(10));
        System.out.println("3 weeks before today was " + today.minusWeeks(3));
        System.out.println("20 months before today was " + today.minusMonths(20));

        // Temporal adjusters for adjusting the dates
        System.out
                .println("First date of this month= " + today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year= " + lastDayOfYear);

        Period period = today.until(lastDayOfYear);
        System.out.println("Period Format= " + period);
        System.out.println("Months remaining in the year= " + period.getMonths());

    }

}
