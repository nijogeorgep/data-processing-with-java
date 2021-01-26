/**
 *
 */
package com.cloudwalker.dateTime;

import java.time.Duration;
import java.time.Instant;

/**
 * @author nijogeorgep
 *
 */
public class InstantDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Current Time stamp
        Instant timeStamp = Instant.now();
        System.out.println("Current Time Stamp : " + timeStamp);

        // Instant From TimeStamp
        Instant specificTime = Instant.ofEpochMilli(timeStamp.toEpochMilli());
        System.out.println("Specific Time : " + specificTime);

        // Duartion
        Duration duartion = Duration.ofDays(2);
        System.out.println("Duration : " + duartion);
    }

}
