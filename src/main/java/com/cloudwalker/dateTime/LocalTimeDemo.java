/**
 *
 */
package com.cloudwalker.dateTime;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 * @author nijogeorgep
 *
 */
public class LocalTimeDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Current Time
        LocalTime timeNow = LocalTime.now();
        System.out.println("Current Time : " + timeNow);

        // Specific Time via Arguments
        LocalTime specificTime = LocalTime.of(18, 30, 00, 400);
        System.out.println("Specific Time : " + specificTime);

        // Time at Time Zone;
        LocalTime timeAtGermany = LocalTime.now(ZoneId.of("Europe/Copenhagen"));
        System.out.println("Time at Time Zone('Germany') : " + timeAtGermany);

        // Get date from the base Date
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("10000th Second Time : " + specificSecondTime);
    }

}
