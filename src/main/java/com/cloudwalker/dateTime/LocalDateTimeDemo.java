/**
 *
 */
package com.cloudwalker.dateTime;

import java.time.*;

/**
 * @author nijogeorgep
 *
 */
public class LocalDateTimeDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Current Date
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Current Date : " + today);

        // Current Date using LocalDate and LocalTime
        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Current Date using LocalDate and LocalTime : " + today);

        // Creating LocalDateTime by providing input arguments
        LocalDateTime specificDateAndTime = LocalDateTime.of(1988, Month.NOVEMBER, 4, 5, 30);
        System.out.println("Specific Date : " + specificDateAndTime);

        // Date and Time @ TimeZone
        LocalDateTime timeAtTimeZone = LocalDateTime.now(ZoneId.of("Europe/Copenhagen"));
        System.out.println("Date and Time at Time zone : " + timeAtTimeZone);

        // Getting date from the base date i.e 01/01/1970
        LocalDateTime timeFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println("Date and Time from Base : " + timeFromBase);

    }

}
