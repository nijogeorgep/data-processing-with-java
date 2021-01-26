/**
 *
 */
package com.cloudwalker.InnerClasses;

/**
 * @author nijogeorgep
 *
 */
public class Computer {
    private String serialNumber = "1234XXX";

    class HardDrive {
        private String serialNumber = "1234DDD";

        void printSN(String serialNumber) {
            System.out.println("SN: " + serialNumber);
            System.out.println("HardDrive SN: " + this.serialNumber);
            System.out.println("Computer SN: " + Computer.this.serialNumber);
        }
    }

}
